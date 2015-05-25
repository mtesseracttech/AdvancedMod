package com.mtesseract.advancedmod.block;

import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.tileentity.TileEntitySpoutLava;
import com.mtesseract.advancedmod.utility.Log;
import com.mtesseract.advancedmod.utility.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 16-05-15
 * Time: 02:40
 */
public class BlockSpoutLava extends BlockAdvancedModTileEntity
{
    public BlockSpoutLava()
    {
        this.setBlockName(Names.Blocks.SPOUT_LAVA);
        this.setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.SPOUT_LAVA);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntitySpoutLava();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        TileEntitySpoutLava te = (TileEntitySpoutLava) world.getTileEntity(x, y, z);
        ItemStack heldItem = player.inventory.getCurrentItem();


        if (heldItem.getItem() == Items.bucket)
        {
            if (te.getTotalLavaInMB() >= 1000)
            {
                te.setTotalLavaInMB(te.getTotalLavaInMB() - 1000);
            }
        }
        else
        {
            Log.info(te.lavaQuantity);
        }
        return true;
    }
}
