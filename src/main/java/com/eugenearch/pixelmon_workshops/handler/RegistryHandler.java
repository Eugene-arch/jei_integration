package com.eugenearch.pixelmon_workshops.handler;

import com.eugenearch.pixelmon_workshops.Reference;
import com.eugenearch.pixelmon_workshops.registry.BlockRegistry;
import com.eugenearch.pixelmon_workshops.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(ItemRegistry.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegistry(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(BlockRegistry.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for (Item item : ItemRegistry.ITEMS) {
            com.eugenearch.pixelmon_workshops.Main.proxy.registerItemRenderer(item, 0, "inventory");
        }

        for (Block block : BlockRegistry.BLOCKS) {
            com.eugenearch.pixelmon_workshops.Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }
}
