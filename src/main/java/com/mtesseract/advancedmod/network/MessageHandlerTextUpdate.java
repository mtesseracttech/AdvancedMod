package com.mtesseract.advancedmod.network;

import com.mtesseract.advancedmod.tileentity.TileEntityAdvancedMod;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 24-05-15
 * Time: 21:37
 */
public class MessageHandlerTextUpdate extends MessageXYZ<MessageHandlerTextUpdate>
{
    private int id;
    private String text;

    public MessageHandlerTextUpdate()
    {
        //Empty constructor to avoid errors
    }

    public MessageHandlerTextUpdate(TileEntityAdvancedMod te, int id, String text)
    {
        super(te);
        this.id = id;
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        super.fromBytes(buf);
        id = buf.readByte();
        text = ByteBufUtils.readUTF8String(buf);


    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        super.toBytes(buf);
        buf.writeByte(id);
        ByteBufUtils.writeUTF8String(buf, text);
    }


    @Override
    public void handleClientSide(MessageHandlerTextUpdate message, EntityPlayer player)
    {
        handleServerSide(message, player);
    }

    @Override
    public void handleServerSide(MessageHandlerTextUpdate message, EntityPlayer player)
    {
        TileEntity te = message.getTileEntity(player.worldObj);
        if (te instanceof TileEntityAdvancedMod)
        {
            ((TileEntityAdvancedMod) te).onGuiTextfieldUpdate(message.id, message.text);
        }
    }
}
