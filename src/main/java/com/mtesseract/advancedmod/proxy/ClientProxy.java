package com.mtesseract.advancedmod.proxy;

import com.mtesseract.advancedmod.client.KeyInputHandler;
import com.mtesseract.advancedmod.client.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by mtesseract on 29-04-15.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInitialization()
    {
        registerKeybinds();
    }

    private void registerKeybinds()
    {
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        for(Keybindings key : Keybindings.values())
        {
            ClientRegistry.registerKeyBinding(key.getKeybind());
        }
    }

    @Override
    public void initialization()
    {

    }

    @Override
    public void postInitialization()
    {

    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }
}
