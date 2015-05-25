package com.mtesseract.advancedmod.init;

import com.mtesseract.advancedmod.tileentity.TileEntityCamoMine;
import com.mtesseract.advancedmod.utility.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 13-05-15
 * Time: 19:14
 */
public class ModTileEntities
{
    public static void initialize()
    {
        GameRegistry.registerTileEntity(TileEntityCamoMine.class, Names.TileEntities.CAMO_MINE);
        GameRegistry.registerTileEntity(TileEntityCamoMine.class, Names.TileEntities.SPOUT_LAVA);
    }
}
