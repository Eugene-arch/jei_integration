package com.eugenearch.pixelmon_workshops.proxy;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class Proxy {
    public abstract void preInit(FMLPreInitializationEvent event);

    public abstract void init(FMLInitializationEvent event);

    public abstract void postInit(FMLPostInitializationEvent event);

    public abstract void registerItemRenderer(Item item, int meta, String id);

    public void spawnParticleMagicSparkleScalableFX(World entityWorld, int i, double d, double e, double f, int j, int k, int l, float g, int m, int n, int o) {
    }

    public void spawnParticleMagicFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicLineFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicAltarLineFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicAltarFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicAltarBigFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicSparkleFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicAuraFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicSmallSparkleFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicSparklePulseFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
    }

    public void spawnParticleMagicSparkleScalableFX(World world, int lifetime, double x, double y, double z, double vx, double vy, double vz, float scale, double r, double g, double b) {
    }

}
