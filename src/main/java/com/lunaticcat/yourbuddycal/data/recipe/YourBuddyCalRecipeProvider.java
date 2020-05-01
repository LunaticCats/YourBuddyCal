package com.lunaticcat.yourbuddycal.data.recipe;


import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.IngredientNBT;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class YourBuddyCalRecipeProvider extends RecipeProvider
{
	public YourBuddyCalRecipeProvider(DataGenerator generator)
	{
		super(generator);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> recipeBuilder)
	{
		//exemple1 :ShapelessRecipeBuilder.shapelessRecipe(Blocks.OAK_PLANKS).addIngredient(MSBlocks.TREATED_PLANKS).addIngredient(Items.WATER_BUCKET).setGroup("planks").addCriterion("has_log", hasItem(MSBlocks.TREATED_PLANKS)).build(recipeBuilder, new ResourceLocation(Minestuck.MOD_ID, "oak_planks_from_treated_planks"));
		//exemple2 :ShapedRecipeBuilder.shapedRecipe(MSBlocks.RAINBOW_PLANKS_STAIRS, 4).key('#', MSBlocks.RAINBOW_PLANKS).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(MSBlocks.RAINBOW_PLANKS)).build(recipeBuilder);
		//exemple3 :CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Items.MUSHROOM_STEW), Items.SLIME_BALL, 0.1F, 20, MSRecipeTypes.IRRADIATING).addCriterion("has_mushroom_stew", hasItem(Items.MUSHROOM_STEW)).build(recipeBuilder, new ResourceLocation(Minestuck.MOD_ID, "slimeball_from_irradiating"));
		//exemple4 :SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(MSBlocks.COARSE_STONE), MSBlocks.COARSE_STONE_STAIRS).addCriterion("has_coarse_stone", hasItem(MSBlocks.COARSE_STONE)).build(recipeBuilder, new ResourceLocation(Minestuck.MOD_ID, "coarse_stone_stairs_from_coarse_stone_stonecutting"));
}
	
	private void cookingRecipesFor(Consumer<IFinishedRecipe> recipeBuilder, Ingredient input, IItemProvider result, float experience, String criterionName, InventoryChangeTrigger.Instance criterion)
	{
		ResourceLocation itemName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result.asItem()), "Registry name for "+result+" was found to be null!");
		CookingRecipeBuilder.smeltingRecipe(input, result, experience, 200).addCriterion(criterionName, criterion).build(recipeBuilder);
		CookingRecipeBuilder.cookingRecipe(input, result, experience, 100, IRecipeSerializer.SMOKING).addCriterion(criterionName, criterion).build(recipeBuilder, new ResourceLocation(itemName.getNamespace(), itemName.getPath()+"_from_smoking"));
		CookingRecipeBuilder.cookingRecipe(input, result, experience, 600, IRecipeSerializer.CAMPFIRE_COOKING).addCriterion(criterionName, criterion).build(recipeBuilder, new ResourceLocation(itemName.getNamespace(), itemName.getPath()+"_from_campfire_cooking"));
	}
	
	@Override
	public String getName()
	{
		return "YourBuddyCal Recipes";
	}
}