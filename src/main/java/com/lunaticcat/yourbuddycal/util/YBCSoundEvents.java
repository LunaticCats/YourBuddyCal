package com.lunaticcat.yourbuddycal.util;

import com.google.common.collect.Lists;
import com.lunaticcat.yourbuddycal.YourBuddyCal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.List;

@ObjectHolder(YourBuddyCal.MOD_ID)
@Mod.EventBusSubscriber(modid = YourBuddyCal.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class YBCSoundEvents
{
	public static final SoundEvent ENTITY_CAL_HURT = getNull();
	public static final SoundEvent ENTITY_CAL_HIT = getNull();
	public static final SoundEvent ENTITY_CAL_AMBIANT = getNull();
	public static final SoundEvent ENTITY_CAL_DEATH = getNull();

    @Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T getNull()
	{
		return null;
	}
	
	@SubscribeEvent
	public static void registerSound(final RegistryEvent.Register<SoundEvent> event)
	{
		List<String> paths = Lists.newArrayList(
				"cal.hurt", "cal.hit", "cal.ambiant", "cal.death");
		
		for(String path : paths)
		{
			ResourceLocation location = new ResourceLocation(YourBuddyCal.MOD_ID, path);
			ResourceLocation name = new ResourceLocation(location.toString().replace('.', '_'));
			event.getRegistry().register(new SoundEvent(location).setRegistryName(name));
		}
	}
}
