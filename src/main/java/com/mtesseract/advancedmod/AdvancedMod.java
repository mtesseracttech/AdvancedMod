package com.mtesseract.advancedmod;

import com.mtesseract.advancedmod.init.ModTileEntities;
import com.mtesseract.advancedmod.network.DescriptionHandler;
import com.mtesseract.advancedmod.network.NetworkHandler;
import com.mtesseract.advancedmod.world.gen.WorldGeneratorFlag;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;

import com.mtesseract.advancedmod.init.ModBlocks;
import com.mtesseract.advancedmod.proxy.CommonProxy;
import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.utility.Log;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by mtesseract on 29-04-15.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class AdvancedMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static AdvancedMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInitialization(FMLPreInitializationEvent event)
    {
        ModBlocks.initialize();
        ModTileEntities.initialize();
        proxy.preInitialization();
        DescriptionHandler.initialize();
        GameRegistry.registerWorldGenerator(new WorldGeneratorFlag(), 0);
        NetworkHandler.initialize();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        Log.info("Pre-Initialization Complete!");
    }

    @Mod.EventHandler
    public void initialization(FMLInitializationEvent event)
    {
        proxy.initialization();
        Log.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInitialization(FMLPostInitializationEvent event)
    {
        proxy.postInitialization();
        Log.info("Post-Initialization Complete!");
    }


}
