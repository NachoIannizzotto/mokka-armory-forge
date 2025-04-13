package net.mokkastudios.mokkasarmory.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.mokkastudios.mokkasarmory.entity.ai.goal.CoreboundMeleeAttackGoal;
import net.mokkastudios.mokkasarmory.entity.ai.goal.CoreboundSlamAttackGoal;
import org.jetbrains.annotations.Nullable;

public class Corebound_GuardianEntity extends Monster {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(Corebound_GuardianEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> HEAVY_ATTACKING =
            SynchedEntityData.defineId(Corebound_GuardianEntity.class, EntityDataSerializers.BOOLEAN);

    public Corebound_GuardianEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0f);
    }
    public int heavyAttackCooldown = 0;

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState heavy_attackAnimationState = new AnimationState();
    public int heavy_attackAnimationTimeout = 0;

    private boolean activating = false;
    private int activationTicks = 0;

    @Override
    public void tick() {
        super.tick();

        if (heavyAttackCooldown > 0) {
            heavyAttackCooldown--;
        }

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {

        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else if (this.idleAnimationTimeout > 0) {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

        if(this.isHeavyAttacking() && heavy_attackAnimationTimeout <= 0) {
            heavy_attackAnimationTimeout = 80;
            heavy_attackAnimationState.start(this.tickCount);
        } else {
            --this.heavy_attackAnimationTimeout;
        }

        if(!this.isHeavyAttacking()){
            heavy_attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setHeavyAttacking(boolean attacking) {
        this.entityData.set(HEAVY_ATTACKING, attacking);
    }

    public boolean isHeavyAttacking() {
        return this.entityData.get(HEAVY_ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(HEAVY_ATTACKING, false);
    }

    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    protected void doPush(Entity pEntity) {
        if (pEntity instanceof Enemy && !(pEntity instanceof Creeper) && this.getRandom().nextInt(20) == 0) {
            this.setTarget((LivingEntity)pEntity);
        }

        super.doPush(pEntity);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new CoreboundSlamAttackGoal(this));
        this.goalSelector.addGoal(4, new CoreboundMeleeAttackGoal(this, 1.0D,true, 6));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.FOLLOW_RANGE, 32D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.ATTACK_DAMAGE, 8f)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.2f)
                .add(Attributes.ARMOR, 10f);
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 3.8F;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypes.FALL) || pSource.is(DamageTypes.ARROW) ||
                pSource.is(DamageTypes.TRIDENT) || pSource.is(DamageTypes.THROWN) ||
                pSource.is(DamageTypes.INDIRECT_MAGIC) || pSource.is(DamageTypes.FIREBALL) ||
                pSource.is(DamageTypes.UNATTRIBUTED_FIREBALL)) {
            return false;
        }

        return super.hurt(pSource, pAmount);
    }

    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < f * 0.3F) {
                pEntity.setSecondsOnFire(2 * (int)f);
            }
        }

        return flag;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.IRON_GOLEM_REPAIR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SHIELD_BREAK;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0F, 0.4F);
    }
}