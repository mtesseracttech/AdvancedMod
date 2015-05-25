package com.mtesseract.advancedmod.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 22-05-15
 * Time: 00:04
 */
public class SlotCamoMine extends Slot
{

    public SlotCamoMine(IInventory inventory, int inventoryIndex, int x, int y)
    {
        super(inventory, inventoryIndex, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return this.inventory.isItemValidForSlot(getSlotIndex(), stack);
    }


}
