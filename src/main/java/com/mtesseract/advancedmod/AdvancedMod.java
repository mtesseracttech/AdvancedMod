package com.mtesseract.advancedmod;

import com.mtesseract.advancedmod.proxy.CommonProxy;
import com.mtesseract.advancedmod.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
        proxy.preInitialization();
    }

    @Mod.EventHandler
    public void initialization(FMLInitializationEvent event)
    {
        proxy.initialization();
    }

    @Mod.EventHandler
    public void postInitialization(FMLPostInitializationEvent event)
    {
        proxy.postInitialization();
    }


}
