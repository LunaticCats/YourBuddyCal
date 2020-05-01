package com.lunaticcat.yourbuddycal.entity.cals;

import com.lunaticcat.yourbuddycal.util.YBCSoundEvents;
import com.lunaticcat.yourbuddycal.util.YBCSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ClassicCalEntity extends CalsEntity
{
    public ClassicCalEntity(EntityType<? extends ClassicCalEntity> type, World world)
    {
        super(type, world);
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
        return 0;
    }

    @Override
    protected float getMaximumHealth() {
        return 0;
    }
}