package com.eugenearch.pixelmon_workshops;

import com.eugenearch.pixelmon_workshops.proxy.Proxy;
import com.eugenearch.pixelmon_workshops.recipes.RecipeHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        dependencies = Reference.MOD_DEPENDENCIES
)
public class Main {
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static Proxy proxy;
    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RecipeHandler.initRecipes();
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
    }
}
