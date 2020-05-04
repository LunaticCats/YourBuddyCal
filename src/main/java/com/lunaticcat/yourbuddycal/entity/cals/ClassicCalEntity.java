package com.lunaticcat.yourbuddycal.entity.cals;

import com.lunaticcat.yourbuddycal.entity.EntityListFilter;
import com.lunaticcat.yourbuddycal.util.YBCSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ClassicCalEntity extends CalsEntity
{
    public ClassicCalEntity(EntityType<? extends ClassicCalEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        attackEntitySelector = new EntityListFilter(new ArrayList<>());
        attackEntitySelector.entityList.add(EntityType.PLAYER);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new ClassicCalEntity.FindPlayerGoal(this));
    }
    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final CalsEntity cal;
        private PlayerEntity player;
        private int aggroTime;
        private int teleportTime;
        private final EntityPredicate variable1;
        private final EntityPredicate viariable2 = (new EntityPredicate()).setLineOfSiteRequired();

        public FindPlayerGoal(CalsEntity variable3) {
            super(variable3, PlayerEntity.class, false);
            this.cal= variable3;
            this.variable1 = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate((variable4) -> {
                return variable3.shouldAttackPlayer((PlayerEntity)variable4);
            });
        }

        public boolean shouldExecute() {
            this.player = this.cal.world.getClosestPlayer(this.variable1, this.cal);
            return this.player != null;
        }

        public void startExecuting() {
            this.aggroTime = 5;
            this.teleportTime = 0;
        }

        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.cal.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.cal.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.nearestTarget != null && this.viariable2.canTarget(this.cal, this.nearestTarget) ? true : super.shouldContinueExecuting();
            }
        }

        public void tick() {
            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.nearestTarget = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            } else {
                if (this.nearestTarget != null && !this.cal.isPassenger()) {
                    if (this.cal.shouldAttackPlayer((PlayerEntity)this.nearestTarget)) {
                        if (this.nearestTarget.getDistanceSq(this.cal) < 16.0D) {
                            this.cal.teleportRandomly();
                        }

                        this.teleportTime = 0;
                    } else if (this.nearestTarget.getDistanceSq(this.cal) > 256.0D && this.teleportTime++ >= 30 && this.cal.teleportToEntity(this.nearestTarget)) {
                        this.teleportTime = 0;
                    }
                }

                super.tick();
            }

        }
    }

    protected SoundEvent getAmbientSound()
    {
        return YBCSoundEvents.ENTITY_CAL_AMBIANT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return YBCSoundEvents.ENTITY_CAL_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return YBCSoundEvents.ENTITY_CAL_DEATH;
    }

    @Override
    protected double getWanderSpeed()
    {
        return 0.6;
    }

    @Override
    protected float getKnockbackResistance()
    {
        return 1;
    }

    @Override
    protected float getMaximumHealth() { return 40; }

    @Override
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
        Entity entity = cause.getTrueSource();
    }
}