package com.eugenearch.pixelmon_workshops.integration.jei.wrapper;

import com.eugenearch.pixelmon_workshops.recipes.RecipeOneblockGenerator;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class WrapperCategoryGeneratorChests implements IRecipeWrapper {
    private final RecipeOneblockGenerator recipe;

    public WrapperCategoryGeneratorChests(RecipeOneblockGenerator recipe) {
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
        minecraft.fontRenderer.drawString("" + level, 10, 26, 0xffffffff, true); // нарисовать число на координатах 22;40
    }

    public RecipeOneblockGenerator getRecipe() {
        return recipe;
    }
}

