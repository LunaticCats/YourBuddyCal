package com.lunaticcat.yourbuddycal.data;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lunaticcat.yourbuddycal.util.Debug;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;

public class YBCAvancementProvider implements IDataProvider
{

	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	private final DataGenerator generator;

	public YBCAvancementProvider(DataGenerator generator)
	{
		this.generator = generator;
	}
	
	protected void buildAdvancements(Consumer<Advancement> advancementSaver)
	{
		//exemple : Advancement root = Advancement.Builder.builder().withDisplay(MSItems.RAW_CRUXITE, new TranslationTextComponent(title(ROOT)), new TranslationTextComponent(desc(ROOT)), new ResourceLocation("minestuck:textures/gui/advancement_bg.png"), FrameType.TASK, false, false, false).withCriterion("raw_cruxite", InventoryChangeTrigger.Instance.forItems(MSItems.RAW_CRUXITE)).register(advancementSaver, Minestuck.MOD_ID+":minestuck/root");
}
	
	private static String title(String name)
	{
		return "advancements."+name+".title";
	}
	private static String desc(String name)
	{
		return "advancements."+name+".description";
	}
	
	@Override
	public void act(DirectoryCache cache)
	{
		Path outputFolder = generator.getOutputFolder();
		Set<ResourceLocation> savedAdvancements = Sets.newHashSet();
		
		buildAdvancements(advancement -> save(cache, outputFolder, savedAdvancements, advancement));
	}
	
	private static void save(DirectoryCache cache, Path outputFolder, Set<ResourceLocation> savedAdvancements, Advancement advancement)
	{
		if(!savedAdvancements.add(advancement.getId()))
		{
			throw new IllegalStateException("Duplicate advancement " + advancement.getId());
		} else
		{
			Path jsonPath = outputFolder.resolve("data/" + advancement.getId().getNamespace() + "/advancements/" + advancement.getId().getPath() + ".json");
			
			try
			{
				IDataProvider.save(GSON, cache, advancement.copy().serialize(), jsonPath);
			} catch(IOException e)
			{
				Debug.logger.error("Couldn't save advancement {}", jsonPath, e);
			}
		}
	}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Advancements";
	}
}