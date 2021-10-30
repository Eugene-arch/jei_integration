package com.eugenearch.pixelmon_workshops.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeOneblockGenerator {
    private final ArrayList<ItemStack> generatedResources;
    private final int level;

    public RecipeOneblockGenerator(int level, ArrayList<ItemStack> blocksToGenerate) {
        this.generatedResources = blocksToGenerate;
        this.level = level;
    }

    public RecipeOneblockGenerator(int level) {
        this(level, new ArrayList<ItemStack>());
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<ItemStack> getOutput() {
        return generatedResources;
    }

    public void addItem(ItemStack itemStack) {
        this.generatedResources.add(itemStack);
    }

    public void addItems(ArrayList<ItemStack> itemStack) {
        generatedResources.addAll(itemStack);
    }
}
