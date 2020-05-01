package com.lunaticcat.yourbuddycal.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

public class YourBuddyCalFluidTagsProvider extends FluidTagsProvider
{
	public YourBuddyCalFluidTagsProvider(DataGenerator generator)
	{
		super(generator);
	}
	
	@Override
	protected void registerTags()
	{
		//exemple : getBuilder(FluidTags.WATER).add(Fluids.OIL, Fluids.BLOOD, Fluids.BRAIN_JUICE, Fluids.WATER_COLORS, Fluids.ENDER, Fluids.LIGHT_WATER);
	}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Fluid Tags";
	}
}