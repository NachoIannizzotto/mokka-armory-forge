package net.mokkastudios.mokkasarmory.entity.ai.goal;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;

import java.util.List;

public class CoreboundSlamAttackGoal extends Goal {
    public final Corebound_GuardianEntity mob;
    private final int slamDuration = 40;
    private final int impactTick = 15;
    private boolean isSlamming = false;
    private int tickCount = 0;
    private double originalSpeed;

    public CoreboundSlamAttackGoal(Corebound_GuardianEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        return mob.getTarget() != null &&
                mob.distanceToSqr(mob.getTarget()) < 36 &&
                mob.heavyAttackCooldown <= 0;
    }

    @Override
    public boolean canContinueToUse() {
        return isSlamming;
    }

    @Override
    public void start() {
        isSlamming = true;
        tickCount = 0;
        mob.setHeavyAttacking(true);
        mob.swing(InteractionHand.MAIN_HAND);

        originalSpeed = mob.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
        mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(originalSpeed * 0.6);
    }

    @Override
    public void tick() {
        tickCount++;

        if (tickCount == impactTick) {
            performSlam();
        }

        if (tickCount >= slamDuration) {
            isSlamming = false;
            mob.heavyAttackCooldown = 200;
            mob.setHeavyAttacking(false);
            mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(originalSpeed);
        }
    }

    @Override
    public void stop() {
        isSlamming = false;
        mob.setHeavyAttacking(false);
        mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(originalSpeed);
    }

    private void performSlam() {
        Vec3 look = mob.getLookAngle().normalize();
        Vec3 origin = mob.position().add(look.scale(2.0));
        double radius = 4.0;

        List<LivingEntity> targets = mob.level().getEntitiesOfClass(LivingEntity.class,
                new AABB(origin.x - radius, origin.y - 1, origin.z - radius,
                        origin.x + radius, origin.y + 2, origin.z + radius),
                e -> e != mob && e.isAlive() && mob.hasLineOfSight(e));

        for (LivingEntity e : targets) {
            e.hurt(mob.damageSources().mobAttack(mob), 16.0f);
            Vec3 kb = e.position().subtract(origin).normalize().scale(1.3);
            e.push(kb.x, 0.4, kb.z);

            if (e instanceof ServerPlayer player) {
                player.disableShield(true);
            }
        }

        mob.playSound(SoundEvents.ANVIL_LAND, 1.0f, 0.2f);
        mob.level().explode(mob, origin.x, origin.y + 0.5, origin.z, 1.4f, Level.ExplosionInteraction.NONE);
    }
}
