package com.lunaticcat.yourbuddycal.data.loot_table;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.ValidationResults;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class YourBuddyCalLootTableProvider extends LootTableProvider
{
	public YourBuddyCalLootTableProvider(DataGenerator generator)
	{
		super(generator);
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> lootTableMap, ValidationResults results)
	{
	
	}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Loot Tables";
	}
}
