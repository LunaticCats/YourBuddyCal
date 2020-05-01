package com.lunaticcat.yourbuddycal.util;

import com.lunaticcat.yourbuddycal.YourBuddyCal;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

public class YBCTags
{
	public static class Blocks
	{
		
		private static Tag<Block> tag(String name)
		{
			return new BlockTags.Wrapper(new ResourceLocation(YourBuddyCal.MOD_ID, name));
		}
	}
	
	public static class Items
	{
		
		private static Tag<Item> tag(String name)
		{
			return new ItemTags.Wrapper(new ResourceLocation(YourBuddyCal.MOD_ID, name));
		}
	}
	
	public static class Fluids
	{
		
		private static Tag<Fluid> tag(String name)
		{
			return new FluidTags.Wrapper(new ResourceLocation(YourBuddyCal.MOD_ID, name));
		}
	}
	
	public static class EntityTypes
	{
		public static final Tag<EntityType<?>> CALS = tag("cals");
		
		private static Tag<EntityType<?>> tag(String name)
		{
			return new EntityTypeTags.Wrapper(new ResourceLocation(YourBuddyCal.MOD_ID, name));
		}
	}
}