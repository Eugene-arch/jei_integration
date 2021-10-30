package com.eugenearch.pixelmon_workshops.integration.jei;

import com.eugenearch.pixelmon_workshops.integration.jei.category.CategoryGeneratorBlocks;
import com.eugenearch.pixelmon_workshops.integration.jei.category.CategoryGeneratorChests;
import com.eugenearch.pixelmon_workshops.integration.jei.category.CategoryGeneratorEntities;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JeiHandler implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) { // Регистрация категории, которая будет показываться в MC.
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(
                new CategoryGeneratorBlocks(guiHelper),
                new CategoryGeneratorChests(guiHelper),
                new CategoryGeneratorEntities(guiHelper)
        );
    }

    @Override
    public void register(IModRegistry registry) {
        CategoryGeneratorBlocks.registerCategory(registry);
        CategoryGeneratorChests.registerCategory(registry);
        CategoryGeneratorEntities.registerCategory(registry);
    }
}
