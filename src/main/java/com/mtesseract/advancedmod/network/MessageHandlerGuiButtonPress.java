package com.mtesseract.advancedmod.network;

import com.mtesseract.advancedmod.tileentity.TileEntityAdvancedMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 24-05-15
 * Time: 01:58
 */
public class MessageHandlerGuiButtonPress extends MessageXYZ<MessageHandlerGuiButtonPress>
{

    private int id;

    public MessageHandlerGuiButtonPress()
    {
    } //Empty constructor to avoid errors


    public MessageHandlerGuiButtonPress(TileEntityAdvancedMod te, int id)
    {
        super(te);
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        super.fromBytes(buf);
        id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        super.toBytes(buf);
        buf.writeInt(id);
    }

    @Override
    public void handleClientSide(MessageHandlerGuiButtonPress message, EntityPlayer player)
    {

    }

    @Override
    public void handleServerSide(MessageHandlerGuiButtonPress message, EntityPlayer player)
    {
        TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
        if (te instanceof TileEntityAdvancedMod)
        {
            ((TileEntityAdvancedMod) te).onGuiButtonPress(message.id);
        }
    }
}
