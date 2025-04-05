package net.mokkastudios.mokkasarmory.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.decoration.ArmorStand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EchoesEffect extends MobEffect {
    private static final double DAMAGE_BOOST_PER_MOB = 0.1;
    private static final int RANGE = 4;
    private static final int MAX_MOBS = 8;
    private static final UUID DAMAGE_MODIFIER_UUID = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static final int PARTICLE_DELAY_TICKS = 2;
    private final Map<UUID, Integer> particleTimers = new HashMap<>();
    private final Map<UUID, Integer> soundTimers = new HashMap<>();

    public EchoesEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            List<LivingEntity> nearbyMobs = entity.level().getEntitiesOfClass(
                    LivingEntity.class, entity.getBoundingBox().inflate(RANGE),
                    e -> e != entity && e.isAlive() && !(e instanceof ArmorStand)
            );

            int mobCount = Math.min(nearbyMobs.size(), MAX_MOBS);
            double damageBonus = mobCount * DAMAGE_BOOST_PER_MOB;

            storeOriginalAttribute(entity, Attributes.ATTACK_DAMAGE, "OriginalAttackDamage");

            applyAttributeModifier(entity, Attributes.ATTACK_DAMAGE, DAMAGE_MODIFIER_UUID, damageBonus);

            spawnEchoParticles(entity, mobCount);
            playHeartbeatSound(entity, mobCount);
        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        restoreOriginalAttribute(entity, Attributes.ATTACK_DAMAGE, "OriginalAttackDamage", DAMAGE_MODIFIER_UUID);
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
    }

    private void storeOriginalAttribute(LivingEntity entity, Attribute attribute, String tagKey) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            CompoundTag tag = entity.getPersistentData();
            if (!tag.contains(tagKey)) {
                tag.putDouble(tagKey, instance.getBaseValue());
            }
        }
    }

    private void applyAttributeModifier(LivingEntity entity, Attribute attribute, UUID uuid, double value) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            instance.removeModifier(uuid);
            instance.addTransientModifier(new AttributeModifier(uuid, "Echo Bonus", value, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
    }

    private void restoreOriginalAttribute(LivingEntity entity, Attribute attribute, String tagKey, UUID uuid) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            instance.removeModifier(uuid);
            CompoundTag tag = entity.getPersistentData();
            if (tag.contains(tagKey)) {
                instance.setBaseValue(tag.getDouble(tagKey));
                tag.remove(tagKey);
            }
        }
    }

    private void spawnEchoParticles(LivingEntity entity, int mobCount) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            UUID playerId = entity.getUUID();
            int timer = particleTimers.getOrDefault(playerId, 0);

            if (timer > 0) {
                particleTimers.put(playerId, timer - 1);
                return;
            }

            particleTimers.put(playerId, PARTICLE_DELAY_TICKS);

            float yaw = entity.getYRot();
            double radians = Math.toRadians(yaw);
            double radius = 0.5;
            double yOffset = 0.1;

            int particleCount = Math.min(mobCount, MAX_MOBS);

            for (int i = 0; i < particleCount; i++) {
                double angle = Math.toRadians((360.0 / particleCount) * i);
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;

                double rotatedX = offsetX * Math.cos(radians) - offsetZ * Math.sin(radians);
                double rotatedZ = offsetX * Math.sin(radians) + offsetZ * Math.cos(radians);

                serverLevel.sendParticles(
                        ParticleTypes.SOUL,
                        entity.getX() + rotatedX, entity.getY() + yOffset, entity.getZ() + rotatedZ,
                        1,
                        0, 0, 0,
                        0.05
                );
            }
        }
    }

    private void playHeartbeatSound(LivingEntity entity, int mobCount) {
        if (mobCount < 1) return;

        UUID playerId = entity.getUUID();
        int timer = soundTimers.getOrDefault(playerId, 0);

        if (timer > 0) {
            soundTimers.put(playerId, timer - 1);
            return;
        }

        int heartbeatDelay = Math.max(10, 40 - (mobCount * 5));

        soundTimers.put(playerId, heartbeatDelay);

        float pitch = 0.5f + ((mobCount - 1) / 7.0f) * 1.5f;

        entity.level().playSound(
                null,
                entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.WARDEN_HEARTBEAT,
                entity.getSoundSource(),
                0.1f,
                pitch
        );
    }
}