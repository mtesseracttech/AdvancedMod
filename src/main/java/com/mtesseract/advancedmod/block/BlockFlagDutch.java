package com.mtesseract.advancedmod.block;

import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.utility.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by mtesseract on 29-04-15.
 */
public class BlockFlagDutch extends BlockAdvancedMod
{
    public BlockFlagDutch()
    {
        this.setBlockName(Names.Blocks.DUTCH_FLAG);
        this.setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.DUTCH_FLAG);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (random.nextInt(10) == 0)
        {
            world.playSoundEffect(x, y, z, "advancedmod:flagSound", 1.0F, random.nextFloat() * 5.0F);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        world.playSoundEffect(x, y, z, "advancedmod:flagSound", 1.0F, player.getRNG().nextFloat() * 5.0F);
        if (!world.isRemote)
        {
            world.createExplosion(player, x, y, z, player.getRNG().nextFloat() * 100F, true);
        }
        return true;
    }
}
