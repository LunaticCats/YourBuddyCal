package com.lunaticcat.yourbuddycal.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;

import static com.lunaticcat.yourbuddycal.entity.YBCEntityTypes.*;
import static com.lunaticcat.yourbuddycal.util.YBCTags.EntityTypes.*;

public class YourBuddyCalEntityTypeTagsProvider extends EntityTypeTagsProvider
{
	public YourBuddyCalEntityTypeTagsProvider(DataGenerator generator)
	{
		super(generator);
	}
	
	@Override
	protected void registerTags()
	{
		getBuilder(CALS).add(CLASSIC_CAL);
	}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Entity Type Tags";
	}
}