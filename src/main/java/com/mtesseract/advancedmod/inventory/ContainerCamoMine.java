package com.mtesseract.advancedmod.inventory;

import com.mtesseract.advancedmod.network.MessageHandlerTextUpdate;
import com.mtesseract.advancedmod.network.NetworkHandler;
import com.mtesseract.advancedmod.tileentity.TileEntityCamoMine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 19-05-15
 * Time: 12:37
 */
public class ContainerCamoMine extends ContainerAdvancedMod
{
    private final TileEntityCamoMine te;
    private int lastTimer = -1;
    private String lastTarget = "";

    public ContainerCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te)
    {
        this.addSlotToContainer(new SlotCamoMine(te, 0, 80, 58));
        this.addSlotToContainer(new SlotCamoMine(te, 1, 80, 22));
        this.addSlotToContainer(new SlotCamoMine(te, 2, 80, 40));
        this.addSlotToContainer(new SlotCamoMine(te, 3, 62, 40));
        this.addSlotToContainer(new SlotCamoMine(te, 4, 98, 40));
        this.addSlotToContainer(new SlotCamoMine(te, 5, 102, 18));

        this.addPlayerSlots(playerInventory, 8, 84);
        this.te = te;
    }


    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return te.isUseableByPlayer(player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value)
    {
        super.updateProgressBar(id, value);
        if (id == 0)
        {
            te.setTimer(value);
        }
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        if (lastTimer != te.getTimer())
        {
            for (ICrafting crafter : (List<ICrafting>) crafters)
            {
                crafter.sendProgressBarUpdate(this, 0, te.getTimer());
            }
            lastTimer = te.getTimer();

        }
        if (!lastTarget.equals(te.getTarget()))
        {
            for (Object crafter : crafters)
            {
                if (crafter instanceof EntityPlayerMP)
                {
                    NetworkHandler.sendTo(new MessageHandlerTextUpdate(te, 0, te.getTarget()), (EntityPlayerMP) crafter);
                }
            }
            lastTarget = te.getTarget();
        }
    }

    @Override
    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            //Only change from here
            if (slotIndex < 6)
            {
                if (!this.mergeItemStack(itemstack1, 6, 42, true))
                {
                    return null;
                }
            }
            else
            {
                if (itemstack1.stackSize == 1)
                {
                    for (int i = 0; i < 6; i++)
                    {

                        Slot shiftedInSlot = ((Slot) inventorySlots.get(i));
                        if (!shiftedInSlot.getHasStack() && shiftedInSlot.isItemValid(itemstack1))
                        {
                            mergeItemStack(itemstack1, i, i + 1, false);
                        }
                    }
                }
            }
            //To here

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}