package com.lunaticcat.yourbuddycal.data;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import static net.minecraft.tags.BlockTags.*;

public class YourBuddyCalBlockTagsProvider extends BlockTagsProvider
{
	YourBuddyCalBlockTagsProvider(DataGenerator generatorIn)
	{
		super(generatorIn);
	}
	
	@Override
	protected void registerTags()
	{
		// exemple : getBuilder(PLANKS).add(GLOWING_PLANKS, FROST_PLANKS, RAINBOW_PLANKS, END_PLANKS, DEAD_PLANKS, TREATED_PLANKS).add(ASPECT_PLANKS);
}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Block Tags";
	}
}
