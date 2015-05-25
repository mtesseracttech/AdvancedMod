package com.mtesseract.advancedmod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 13-05-15
 * Time: 15:37
 */
public abstract class BlockAdvancedModTileEntity extends BlockContainer
{
    public BlockAdvancedModTileEntity(Material material)
    {
        super(material);
    }

    public BlockAdvancedModTileEntity()
    {
        this(Material.rock);
    }
}
