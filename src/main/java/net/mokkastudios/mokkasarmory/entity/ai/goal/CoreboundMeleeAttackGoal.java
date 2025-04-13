package net.mokkastudios.mokkasarmory.entity.ai.goal;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;

import java.util.List;

public class CoreboundMeleeAttackGoal extends MeleeAttackGoal {
    public final Corebound_GuardianEntity entity;
    private final double aoeRadius;
    private final int animationDuration = 20;
    private final int attackImpactTick = 10;
    private int animationTick = 0;
    private boolean attacking = false;

    public CoreboundMeleeAttackGoal(PathfinderMob mob, double speed, boolean followEvenIfNotSeen, double aoeRadius) {
        super(mob, speed, followEvenIfNotSeen);
        this.entity = (Corebound_GuardianEntity) mob;
        this.aoeRadius = aoeRadius;
    }

    @Override
    public void start() {
        super.start();
        animationTick = 0;
        attacking = false;
    }

    @Override
    public void tick() {
        super.tick();

        if (attacking) {
            animationTick++;

            if (animationTick == attackImpactTick) {
                performAttack();
            }

            if (animationTick >= animationDuration) {
                attacking = false;
                entity.setAttacking(false);
            }
        }
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target, double distToEnemySqr) {
        if (entity.isHeavyAttacking()) return;

        if (distToEnemySqr <= getAttackReachSqr(target) && !attacking && !entity.isAttacking()) {
            attacking = true;
            animationTick = 0;
            entity.setAttacking(true);
            mob.swing(InteractionHand.MAIN_HAND);
        }
    }

    protected void performAttack() {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);

        double aoeRadius = 3.0;
        Vec3 lookVec = this.mob.getLookAngle().normalize();
        Vec3 origin = this.mob.position().add(lookVec.scale(aoeRadius / 2.0));

        List<LivingEntity> aoeEntities = this.mob.level().getEntitiesOfClass(LivingEntity.class,
                new AABB(
                        origin.x - aoeRadius, origin.y - 1.0, origin.z - aoeRadius,
                        origin.x + aoeRadius, origin.y + 2.0, origin.z + aoeRadius
                ),
                e -> e != this.mob && e.isAlive() && this.mob.hasLineOfSight(e)
        );

        for (LivingEntity e : aoeEntities) {
            double distance = origin.distanceTo(e.position());
            if (distance <= aoeRadius) {
                this.mob.doHurtTarget(e);
            }
        }
    }

    @Override
    public boolean canUse() {
        return !entity.isHeavyAttacking() && super.canUse();
    }

    @Override
    public void stop() {
        super.stop();
        attacking = false;
        entity.setAttacking(false);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity p_25557_) {
        return 9.0;
    }
}
