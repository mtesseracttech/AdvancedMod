package com.mtesseract.advancedmod.block;

import com.mtesseract.advancedmod.init.ModBlocks;
import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.utility.Names;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 13-05-15
 * Time: 13:27
 */
public class BlockCreep extends BlockAdvancedMod
{
    public BlockCreep()
    {
        this.setBlockName(Names.Blocks.CREEP);
        this.setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.CREEP);
        setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        spreadCreep(world, x, y, z);
    }

    public void spreadCreep(World world, int x, int y, int z)
    {
        Random random = new Random();
        int side = random.nextInt(6);
        switch (side)
        {
            case 0:
                world.setBlock(x - 1, y, z, ModBlocks.blockCreep);
                break;
            case 1:
                world.setBlock(x + 1, y, z, ModBlocks.blockCreep);
                break;
            case 2:
                world.setBlock(x, y - 1, z, ModBlocks.blockCreep);
                break;
            case 3:
                world.setBlock(x, y + 1, z, ModBlocks.blockCreep);
                break;
            case 4:
                world.setBlock(x, y, z - 1, ModBlocks.blockCreep);
                break;
            case 5:
                world.setBlock(x, y, z + 1, ModBlocks.blockCreep);
                break;
        }
    }
}