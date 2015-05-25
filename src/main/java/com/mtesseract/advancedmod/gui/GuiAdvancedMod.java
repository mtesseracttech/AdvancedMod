package com.mtesseract.advancedmod.gui;

import com.mtesseract.advancedmod.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 20-05-15
 * Time: 00:42
 */
public abstract class GuiAdvancedMod extends GuiContainer
{
    private ResourceLocation guiTexture;
    private IInventory inventory;

    public GuiAdvancedMod(Container container, String guiTextureName, IInventory inventory)
    {
        super(container);
        guiTexture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/" + guiTextureName + ".png");
        this.inventory = inventory;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        mc.getTextureManager().bindTexture(guiTexture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = inventory.hasCustomInventoryName() ? inventory.getInventoryName() : I18n.format(inventory.getInventoryName());
        fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    public void onTextfieldUpdate(int id){}
}
