package com.mtesseract.advancedmod.gui;

import com.mtesseract.advancedmod.inventory.ContainerCamoMine;
import com.mtesseract.advancedmod.network.MessageHandlerGuiButtonPress;
import com.mtesseract.advancedmod.network.MessageHandlerTextUpdate;
import com.mtesseract.advancedmod.network.NetworkHandler;
import com.mtesseract.advancedmod.tileentity.TileEntityCamoMine;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 20-05-15
 * Time: 00:46
 */
public class GuiCamoMine extends GuiAdvancedMod
{
    private final TileEntityCamoMine te;
    private GuiButton resetButton;
    private GuiTextField tbPlayerName;

    public GuiCamoMine(InventoryPlayer playerInventory, TileEntityCamoMine te)
    {
        super(new ContainerCamoMine(playerInventory, te), "camoMine", te);
        this.te = te;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.fontRendererObj.drawString(I18n.format("gui.advancedmod.mineCamo.timer", secondCounter()), 7, 60, 4210752);
        this.fontRendererObj.drawString(I18n.format("gui.advancedmod.mineCamo.target", secondCounter()), 118, 50, 4210752);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        resetButton = new GuiButton(0, guiLeft + 7, guiTop + 37, 40, 20, I18n.format("gui.advancedmod.mineCamo.button.reset"));
        buttonList.add(resetButton);

        this.tbPlayerName = new GuiTextField(this.fontRendererObj, guiLeft + 100, guiTop + 60, 68, 12);
        this.tbPlayerName.setMaxStringLength(40);
        this.tbPlayerName.setText(te.getTarget());
    }

    /**
     * Called when the mouse is clicked.
     */

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int button)
    {
        super.mouseClicked(mouseX, mouseY, button);
        this.tbPlayerName.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        super.drawScreen(mouseX, mouseY, partialTick);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        this.tbPlayerName.drawTextBox();
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    @Override
    protected void keyTyped(char chr, int keyCode)
    {
        if (this.tbPlayerName.textboxKeyTyped(chr, keyCode))
        {
            NetworkHandler.sendToServer(new MessageHandlerTextUpdate(te, 0, tbPlayerName.getText()));
        }
        else
        {
            super.keyTyped(chr, keyCode);
        }
    }


    @Override
    protected void actionPerformed(GuiButton button)
    {
        if (button.id == 0) NetworkHandler.sendToServer(new MessageHandlerGuiButtonPress(te, 0));
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
        resetButton.displayString = I18n.format("gui.advancedmod.mineCamo.button." + (te.getTimer() == -1 ? "restart" : "reset"));
    }


    private String secondCounter()
    {
        if (te.getTimer() > 0)
        {
            return te.getTimer() / 20 + 1 + " sec.";
        }
        else if (te.getTimer() == 0)
        {
            return "Armed!";
        }
        else
        {
            return "Safe";
        }
    }

}
