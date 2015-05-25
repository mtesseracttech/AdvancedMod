package com.mtesseract.advancedmod;

import com.mtesseract.advancedmod.gui.GuiCamoMine;
import com.mtesseract.advancedmod.inventory.ContainerCamoMine;

import com.mtesseract.advancedmod.tileentity.TileEntityCamoMine;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 19-05-15
 * Time: 02:21
 */
public class GuiHandler implements IGuiHandler
{

    public enum GuiIDs
    {
        CAMO_MINE;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (GuiIDs.values()[ID])
        {
            case CAMO_MINE:
                return new ContainerCamoMine(player.inventory, (TileEntityCamoMine)world.getTileEntity(x, y, z));
        }
        throw new IllegalArgumentException("No GUI with ID: " + ID);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (GuiIDs.values()[ID])
        {
            case CAMO_MINE:
                return new GuiCamoMine(player.inventory, (TileEntityCamoMine)world.getTileEntity(x, y, z));
        }
        throw new IllegalArgumentException("No GUI with ID: " + ID);
    }
}
