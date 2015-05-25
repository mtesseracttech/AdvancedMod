package com.mtesseract.advancedmod.proxy;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by mtesseract on 29-04-15.
 */
public abstract class CommonProxy
{
    public abstract void preInitialization();

    public abstract void initialization();

    public abstract void postInitialization();

    public abstract EntityPlayer getClientPlayer();

}
