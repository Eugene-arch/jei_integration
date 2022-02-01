package com.eugenearch.pixelmon_workshops.integration.jei.wrapper;

import com.eugenearch.pixelmon_workshops.recipes.RecipeOneblockGenerator;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class WrapperCategoryGeneratorLoot implements IRecipeWrapper {
    private final RecipeOneblockGenerator recipe;

    public WrapperCategoryGeneratorLoot(RecipeOneblockGenerator recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        for (ItemStack item : recipe.getOutput())
            ingredients.setOutput(VanillaTypes.ITEM, item);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        int level = recipe.getLevel();
        minecraft.fontRenderer.drawString("" + level, 2, 4, 0xffffffff, true);
    }

    public RecipeOneblockGenerator getRecipe() {
        return recipe;
    }
}

