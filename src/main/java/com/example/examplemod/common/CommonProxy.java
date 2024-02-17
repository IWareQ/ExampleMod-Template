package com.example.examplemod.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;

/**
 * ExampleMod Project 17/02/2024
 *
 * @author IWareQ
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        // NO-OP
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }

    public void postInit(FMLPostInitializationEvent event) {
        // NO-OP
    }
}
