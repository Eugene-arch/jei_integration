package com.eugenearch.pixelmon_workshops.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeHandlerOneblockGenerator {
    public static final ArrayList<RecipeOneblockGenerator> BLOCK_CATEGORIES = new ArrayList<RecipeOneblockGenerator>();
    public static final ArrayList<RecipeOneblockGenerator> CHEST_CATEGORIES = new ArrayList<RecipeOneblockGenerator>();
    public static final ArrayList<RecipeOneblockGenerator> ENTITY_CATEGORIES = new ArrayList<RecipeOneblockGenerator>();

    public static void initRecipes() {
        // Blocks
        ArrayList<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Blocks.COBBLESTONE));
        items.add(new ItemStack(Blocks.STONE));
        items.add(new ItemStack(Blocks.SAND));
        addBlockLevel(1, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Blocks.IRON_ORE));
        items.add(new ItemStack(Blocks.GOLD_ORE));
        items.add(new ItemStack(Blocks.DIAMOND_ORE));
        addBlockLevel(5, items);

        // Chests
        items = new ArrayList<>();
        items.add(new ItemStack(Items.APPLE));
        items.add(new ItemStack(Items.LAVA_BUCKET));
        items.add(new ItemStack(Items.WATER_BUCKET));
        addChestLevel(2, items);

        items = new ArrayList<>();
        items.add(new ItemStack(Items.GOLDEN_PICKAXE));
        addChestLevel(10, items);

        // Entities
        items = new ArrayList<>();
        items.add((new ItemStack(Items.SPAWN_EGG)).setStackDisplayName("§eSkeleton"));
        items.add((new ItemStack(Items.SPAWN_EGG)).setStackDisplayName("§eZombie"));
        items.add((new ItemStack(Items.SPAWN_EGG)).setStackDisplayName("§eSpider"));
        addEntityLevel(15, items);
    }

    public static RecipeOneblockGenerator getBlockCategoryByLevel(int level) {
        for (RecipeOneblockGenerator recipe : BLOCK_CATEGORIES)
            if (recipe.getLevel() == level)
                return recipe;
        return null;
    }

    public static RecipeOneblockGenerator getChestCategoryByLevel(int level) {
        for (RecipeOneblockGenerator recipe : CHEST_CATEGORIES)
            if (recipe.getLevel() == level)
                return recipe;
        return null;
    }

    public static RecipeOneblockGenerator getEntityCategoryByLevel(int level) {
        for (RecipeOneblockGenerator recipe : CHEST_CATEGORIES)
            if (recipe.getLevel() == level)
                return recipe;
        return null;
    }

    public static void addBlockLevel(int level, ArrayList<ItemStack> items) {
        RecipeOneblockGenerator recipe = getBlockCategoryByLevel(level);
        if (recipe == null) {
            BLOCK_CATEGORIES.add(new RecipeOneblockGenerator(level, items));
        } else {
            recipe.addItems(items);
        }
    }

    public static void addChestLevel(int level, ArrayList<ItemStack> items) {
        RecipeOneblockGenerator recipe = getChestCategoryByLevel(level);
        if (recipe == null) {
            CHEST_CATEGORIES.add(new RecipeOneblockGenerator(level, items));
        } else {
            recipe.addItems(items);
        }
    }

    public static void addEntityLevel(int level, ArrayList<ItemStack> items) {
        RecipeOneblockGenerator recipe = getEntityCategoryByLevel(level);
        if (recipe == null) {
            ENTITY_CATEGORIES.add(new RecipeOneblockGenerator(level, items));
        } else {
            recipe.addItems(items);
        }
    }
}
