package com.eugenearch.pixelmon_workshops.integration.jei.category;

import com.eugenearch.pixelmon_workshops.Reference;
import com.eugenearch.pixelmon_workshops.integration.jei.wrapper.WrapperCategoryGeneratorLoot;
import com.eugenearch.pixelmon_workshops.recipes.RecipeHandlerOneblockGeneratorTiered;
import com.eugenearch.pixelmon_workshops.recipes.RecipeOneblockGenerator;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class CategoryGeneratorLoot implements IRecipeCategory<WrapperCategoryGeneratorLoot> {
    public static final String UID = Reference.MOD_ID + ":jei_category_oneblock_loot_tier";
    private final IDrawableStatic background;
    private final String lang;
    private final IDrawable icon;
    private final int generatorLevel;
    private WrapperCategoryGeneratorLoot wrapper;

    public CategoryGeneratorLoot(IGuiHelper guiHelper, int generatorLevel) {
        this.background = guiHelper.createDrawable(new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/jei_loot_tier" + generatorLevel + ".png"), 0, 0, 332/2, 114/2); // tab texture
        this.lang = "jei.category.oneblock.loot.tier" + generatorLevel + ".name"; // локализация названия вкладки
        switch (generatorLevel) { // иконка вкладки
            case 1:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.COAL)); // TODO: изменить BItems.COAL на генератор ресурсов 1 лвл
                break;
            case 2:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.IRON_INGOT)); // TODO: изменить Items.IRON_INGOT на генератор ресурсов 2 лвл
                break;
            case 3:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.GOLD_INGOT)); // TODO: изменить Items.GOLD_INGOT на генератор ресурсов 3 лвл
                break;
            case 4:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.DIAMOND)); // TODO: изменить Items.DIAMOND на генератор ресурсов 4 лвл
                break;
            case 5:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.EMERALD)); // TODO: изменить Items.EMERALD на генератор ресурсов 5 лвл
                break;
            default:
                this.icon = guiHelper.createDrawableIngredient(new ItemStack(Blocks.BARRIER));
        }
        this.generatorLevel = generatorLevel;
    }

    public static void registerCategory(IModRegistry registry) {
        registry.addRecipes(RecipeHandlerOneblockGeneratorTiered.TIER1_CATEGORIES, CategoryGeneratorLoot.UID + 1); // коллекция рецептов, id категории
        registry.addRecipes(RecipeHandlerOneblockGeneratorTiered.TIER2_CATEGORIES, CategoryGeneratorLoot.UID + 2); // коллекция рецептов, id категории
        registry.addRecipes(RecipeHandlerOneblockGeneratorTiered.TIER3_CATEGORIES, CategoryGeneratorLoot.UID + 3); // коллекция рецептов, id категории
        registry.addRecipes(RecipeHandlerOneblockGeneratorTiered.TIER4_CATEGORIES, CategoryGeneratorLoot.UID + 4); // коллекция рецептов, id категории
        registry.addRecipes(RecipeHandlerOneblockGeneratorTiered.TIER5_CATEGORIES, CategoryGeneratorLoot.UID + 5); // коллекция рецептов, id категории

        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorLoot::new, CategoryGeneratorLoot.UID + 1); // класс рецепта, враппер, id категории
        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorLoot::new, CategoryGeneratorLoot.UID + 2); // класс рецепта, враппер, id категории
        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorLoot::new, CategoryGeneratorLoot.UID + 3); // класс рецепта, враппер, id категории
        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorLoot::new, CategoryGeneratorLoot.UID + 4); // класс рецепта, враппер, id категории
        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorLoot::new, CategoryGeneratorLoot.UID + 5); // класс рецепта, враппер, id категории

        registry.addRecipeCatalyst(new ItemStack(Blocks.BEACON), CategoryGeneratorLoot.UID + 1); // TODO: изменить Blocks.BEACON на ItemStack генератора ресурсов 1 лвл
        registry.addRecipeCatalyst(new ItemStack(Blocks.BEACON), CategoryGeneratorLoot.UID + 2); // TODO: изменить Blocks.BEACON на ItemStack генератора ресурсов 2 лвл
        registry.addRecipeCatalyst(new ItemStack(Blocks.BEACON), CategoryGeneratorLoot.UID + 3); // TODO: изменить Blocks.BEACON на ItemStack генератора ресурсов 3 лвл
        registry.addRecipeCatalyst(new ItemStack(Blocks.BEACON), CategoryGeneratorLoot.UID + 4); // TODO: изменить Blocks.BEACON на ItemStack генератора ресурсов 4 лвл
        registry.addRecipeCatalyst(new ItemStack(Blocks.BEACON), CategoryGeneratorLoot.UID + 5); // TODO: изменить Blocks.BEACON на ItemStack генератора ресурсов 5 лвл
    }

    @Override
    public String getUid() {
        return UID + generatorLevel;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public String getTitle() {
        return I18n.format(lang);
    }

    @Override
    public String getModName() {
        return Reference.MOD_NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, WrapperCategoryGeneratorLoot recipeWrapper, IIngredients ingredients) {
        wrapper = recipeWrapper;

        IGuiItemStackGroup isg = recipeLayout.getItemStacks();

        int index = 0;

        int xStart = 78/2 - 1;
        int yStart = 6/2 - 1;
        int xSpace = 36/2;
        int ySpace = 36/2;

        ArrayList<ItemStack> items = wrapper.getRecipe().getOutput();
        for (ItemStack item : items) {
            isg.init(index, false, xStart + index % 7 * xSpace, yStart + index / 7 * ySpace); // добавление выходного слота (у нас все такие)
            isg.set(index++, item);
        }
    }
}
