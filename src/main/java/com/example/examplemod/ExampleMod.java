package com.example.examplemod;

import com.example.examplemod.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * ExampleMod Project 17/02/2024
 *
 * @author IWareQ
 */
@Mod(modid = ExampleMod.MOD_ID, version = ExampleMod.VERSION)
public class ExampleMod {

    public static final String MOD_ID = "examplemod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static ExampleMod instance;

    @SidedProxy(
            clientSide = "com.example.examplemod.client.ClientProxy",
            serverSide = "com.example.examplemod.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
