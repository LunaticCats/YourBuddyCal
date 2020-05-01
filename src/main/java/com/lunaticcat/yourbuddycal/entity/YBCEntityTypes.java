package com.lunaticcat.yourbuddycal.entity;

import com.lunaticcat.yourbuddycal.YourBuddyCal;
import com.lunaticcat.yourbuddycal.entity.cals.ClassicCalEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(YourBuddyCal.MOD_ID)
@Mod.EventBusSubscriber(modid = YourBuddyCal.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public final class YBCEntityTypes
{
    public static final EntityType<ClassicCalEntity> ClassicCal = getNull();

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static <T> T getNull()
    {
        return null;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        register(registry, EntityType.Builder.create(ClassicCalEntity::new, EntityClassification.MONSTER).size(3F, 2F), "classic_cal");
}

    public static void registerPlacements()
    {
    }

    private static void register(IForgeRegistry<EntityType<?>> registry, EntityType.Builder<?> builder, String name)
    {
        EntityType<?> type = builder.build(YourBuddyCal.MOD_ID + ":" + name);
        registry.register(type.setRegistryName(name));
    }
}