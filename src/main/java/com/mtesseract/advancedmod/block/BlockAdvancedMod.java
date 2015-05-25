package com.mtesseract.advancedmod.block;

import com.mtesseract.advancedmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import cpw.mods.fml.relauncher.SideOnly;

/**
 * Created by mtesseract on 29-04-15.
 */

public class BlockAdvancedMod extends Block
{
    public BlockAdvancedMod(Material material)
    {
        super(material);
    }

    public BlockAdvancedMod()
    {
        this(Material.rock);
    }
}
