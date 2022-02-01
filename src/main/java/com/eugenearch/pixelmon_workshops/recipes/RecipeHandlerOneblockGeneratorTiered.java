package com.eugenearch.pixelmon_workshops.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeHandlerOneblockGeneratorTiered {
    public static final ArrayList<RecipeOneblockGenerator> TIER1_CATEGORIES = new ArrayList<>();
    public static final ArrayList<RecipeOneblockGenerator> TIER2_CATEGORIES = new ArrayList<>();
    public static final ArrayList<RecipeOneblockGenerator> TIER3_CATEGORIES = new ArrayList<>();
    public static final ArrayList<RecipeOneblockGenerator> TIER4_CATEGORIES = new ArrayList<>();
    public static final ArrayList<RecipeOneblockGenerator> TIER5_CATEGORIES = new ArrayList<>();

    public static void initRecipes() {
        ArrayList<ItemStack> items;

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.COBBLESTONE));
        items.add(new ItemStack(Blocks.STONE));
        items.add(new ItemStack(Blocks.DIRT));
        addBlockLevel(1, 1, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.STONE));
        items.add(new ItemStack(Blocks.COAL_ORE));
        items.add(new ItemStack(Blocks.IRON_ORE));
        items.add(new ItemStack(Blocks.GOLD_ORE));
        addBlockLevel(1, 2, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.DIAMOND_ORE));
        items.add(new ItemStack(Blocks.EMERALD_ORE));
        items.add(new ItemStack(Blocks.LAPIS_ORE));
        items.add(new ItemStack(Blocks.REDSTONE_ORE));
        addBlockLevel(1, 3, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.QUARTZ_ORE));
        items.add(new ItemStack(Blocks.NETHERRACK));
        items.add(new ItemStack(Blocks.GLOWSTONE));
        addBlockLevel(1, 4, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.CHORUS_FLOWER));
        items.add(new ItemStack(Blocks.DRAGON_EGG));
        items.add(new ItemStack(Blocks.END_STONE));
        addBlockLevel(1, 5, items);
    }

    public static RecipeOneblockGenerator getBlockCategoryByLevel(int islandLevel, int generatorLevel) {
        ArrayList<RecipeOneblockGenerator> recipes = null;
        switch (generatorLevel) {
            case 1:
                recipes = TIER1_CATEGORIES;
                break;
            case 2:
                recipes = TIER2_CATEGORIES;
                break;
            case 3:
                recipes = TIER3_CATEGORIES;
                break;
            case 4:
                recipes = TIER4_CATEGORIES;
                break;
            case 5:
                recipes = TIER5_CATEGORIES;
                break;
            default:
                return null;
        }
        for (RecipeOneblockGenerator recipe : recipes)
            if (recipe.getLevel() == islandLevel)
                return recipe;
        return null;
    }

    public static void addBlockLevel(int islandLevel, int generatorLevel, ArrayList<ItemStack> items) {
        if (generatorLevel < 1 || generatorLevel > 5) return;
        RecipeOneblockGenerator recipe = getBlockCategoryByLevel(islandLevel, generatorLevel);
        if (recipe == null) {
            ArrayList<RecipeOneblockGenerator> recipes = null;
            switch (generatorLevel) {
                case 1:
                    TIER1_CATEGORIES.add(new RecipeOneblockGenerator(islandLevel, items));
                    break;
                case 2:
                    TIER2_CATEGORIES.add(new RecipeOneblockGenerator(islandLevel, items));
                    break;
                case 3:
                    TIER3_CATEGORIES.add(new RecipeOneblockGenerator(islandLevel, items));
                    break;
                case 4:
                    TIER4_CATEGORIES.add(new RecipeOneblockGenerator(islandLevel, items));
                    break;
                case 5:
                    TIER5_CATEGORIES.add(new RecipeOneblockGenerator(islandLevel, items));
            }
        } else {
            recipe.addItems(items);
        }
    }
}
