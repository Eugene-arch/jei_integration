package com.eugenearch.pixelmon_workshops.integration.jei.category;

import com.eugenearch.pixelmon_workshops.Reference;
import com.eugenearch.pixelmon_workshops.integration.jei.wrapper.WrapperCategoryGeneratorBlocks;
import com.eugenearch.pixelmon_workshops.recipes.RecipeOneblockGenerator;
import com.eugenearch.pixelmon_workshops.recipes.RecipeHandlerOneblockGenerator;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class CategoryGeneratorBlocks implements IRecipeCategory<WrapperCategoryGeneratorBlocks> {
    public static final String UID = Reference.MOD_ID + ":jei_category_oneblock_blocks";
    private final IDrawableStatic background;
    private final String lang;
    private final IDrawable icon;
    private WrapperCategoryGeneratorBlocks wrapper;

    public CategoryGeneratorBlocks(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/jei_blocks.png"), 0, 0, 332/2, 114/2); // tab texture
        lang = "jei.category.oneblock.blocks.name"; // локализация названия вкладки
        icon = guiHelper.createDrawableIngredient(new ItemStack(Items.DIAMOND_PICKAXE)); // иконка вкладки
    }

    public static void registerCategory(IModRegistry registry) {
        registry.addRecipes(RecipeHandlerOneblockGenerator.BLOCK_CATEGORIES, CategoryGeneratorBlocks.UID); // коллекция рецептов, id категории

        registry.handleRecipes(RecipeOneblockGenerator.class, WrapperCategoryGeneratorBlocks::new, CategoryGeneratorBlocks.UID); // класс рецепта, враппер, id категории

        registry.addRecipeCatalyst(new ItemStack(Items.WOODEN_PICKAXE), CategoryGeneratorBlocks.UID);
        registry.addRecipeCatalyst(new ItemStack(Items.STONE_PICKAXE), CategoryGeneratorBlocks.UID);
        registry.addRecipeCatalyst(new ItemStack(Items.IRON_PICKAXE), CategoryGeneratorBlocks.UID);
        registry.addRecipeCatalyst(new ItemStack(Items.GOLDEN_PICKAXE), CategoryGeneratorBlocks.UID);
        registry.addRecipeCatalyst(new ItemStack(Items.DIAMOND_PICKAXE), CategoryGeneratorBlocks.UID);

//        registry.addRecipeClickArea(GuiMelter.class, 50, 45, 32, 15, VanillaRecipeCategoryUid.SMELTING); // добавление клик-области в интерфейсе блока (можно в ресурс генератор добавить клик-область на страницу с блоками)
    }

    @Override
    public String getUid() {
        return UID;
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
    public void setRecipe(IRecipeLayout recipeLayout, WrapperCategoryGeneratorBlocks recipeWrapper, IIngredients ingredients) {
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
