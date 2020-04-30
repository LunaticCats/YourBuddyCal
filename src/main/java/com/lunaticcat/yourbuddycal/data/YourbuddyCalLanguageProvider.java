package com.lunaticcat.yourbuddycal.data;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;


@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class YourbuddyCalLanguageProvider extends LanguageProvider
{
	private final String modid;

	public YourbuddyCalLanguageProvider(DataGenerator gen, String modid, String locale)
	{
		super(gen, modid, locale);
		this.modid = modid;
	}
	
	protected void addBlockTooltip(Supplier<Block> key, String value)
	{
		addTooltip(key.get(), value);
	}
	protected void addItemTooltip(Supplier<Item> key, String value)
	{
		addTooltip(key.get(), value);
	}
	protected void addTooltip(IItemProvider key, String value)
	{
		addExtra(key, "tooltip", value);
	}
	protected void addBlockExtra(Supplier<Block> key, String type, String value)
	{
		addExtra(key.get(), type, value);
	}
	protected void addItemExtra(Supplier<Item> key, String type, String value)
	{
		addExtra(key.get(), type, value);
	}
	protected void addExtra(IItemProvider key, String type, String value)
	{
		add(key.asItem().getTranslationKey()+"."+type, value);
	}
	protected void addBlockStore(Supplier<Block> key, String value)
	{
		addStore(key.get(), value);
	}
	protected void addItemStore(Supplier<Item> key, String value)
	{
		addStore(key.get(), value);
	}
	protected void addStore(IItemProvider key, String value)
	{
		add("store."+key.asItem().getTranslationKey(), value);
	}
	protected void addItemStackStore(Supplier<ItemStack> key, String value)
	{
		addStore(key.get(), value);
	}
	protected void addStore(ItemStack key, String value)
	{
		add("store."+key.getTranslationKey(), value);
	}
	protected void addBlockStoreTooltip(Supplier<Block> key, String value)
	{
		addStoreTooltip(key.get(), value);
	}
	protected void addItemStoreTooltip(Supplier<Item> key, String value)
	{
		addStoreTooltip(key.get(), value);
	}
	protected void addStoreTooltip(IItemProvider key, String value)
	{
		add("store."+key.asItem().getTranslationKey()+".tooltip", value);
	}
	protected void addItemStackStoreTooltip(Supplier<ItemStack> key, String value)
	{
		addStoreTooltip(key.get(), value);
	}
	protected void addStoreTooltip(ItemStack key, String value)
	{
		add("store."+key.getTranslationKey()+".tooltip", value);
	}
	protected void add(ItemGroup key, String value)
	{
		add(key.getTranslationKey(), value);
	}
	protected void addEntityTypeExtra(Supplier<EntityType<?>> key, String type, String value)
	{
		addExtra(key.get(), type, value);
	}
	protected void addExtra(EntityType<?> key, String type, String value)
	{
		add(key.getTranslationKey()+"."+type, value);
	}
	protected void addAdvancement(String key, String title, String description)
	{
		add("advancements."+key+".title", title);
		add("advancements."+key+".description", description);
	}
	protected void addDialogue(String key, String value)
	{
		add("consort."+key, value);
	}
	protected void addSubtitles(String key, String value)
	{
		add("subtitles."+modid+"."+key, value);
	}
	protected void addEntitySubtitles(EntityType<?> type, String key, String value)
	{
		add("subtitles."+type.getTranslationKey()+"."+key, value);
	}
}