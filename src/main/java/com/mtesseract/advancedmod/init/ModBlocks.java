package com.mtesseract.advancedmod.init;

import com.mtesseract.advancedmod.block.*;
import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.utility.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by mtesseract on 04-05-15.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final Block dutchFlag = new BlockFlagDutch();
    public static final Block blockCreep = new BlockCreep();
    public static final Block mineCamo = new BlockCamoMine();
    public static final Block spoutLava = new BlockSpoutLava();



    public static void initialize()
    {
        GameRegistry.registerBlock(dutchFlag, Names.Blocks.DUTCH_FLAG);
        GameRegistry.registerBlock(blockCreep, Names.Blocks.CREEP);
        GameRegistry.registerBlock(mineCamo, Names.Blocks.CAMO_MINE);
        GameRegistry.registerBlock(spoutLava, Names.Blocks.SPOUT_LAVA);
    }
}