package com.lunaticcat.yourbuddycal.entity.cals;

import com.lunaticcat.yourbuddycal.entity.ai.AttackOnCollideWithRateGoal;
import com.lunaticcat.yourbuddycal.util.YBCSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ClassicCalEntity extends CalsEntity
{
    public ClassicCalEntity(EntityType<? extends ClassicCalEntity> type, World world)
    {
        super(type, world);
    }
    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        AttackOnCollideWithRateGoal aiAttack = new AttackOnCollideWithRateGoal(this, .4F, 20, false);
        this.goalSelector.addGoal(3, aiAttack);
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
    protected float getMaximumHealth() { return 20; }

    @Override
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
        Entity entity = cause.getTrueSource();
    }
}