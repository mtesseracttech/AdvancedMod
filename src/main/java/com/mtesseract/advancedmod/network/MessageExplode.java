package com.mtesseract.advancedmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 12-05-15
 * Time: 16:35
 */
public class MessageExplode extends MessageBase<MessageExplode>
{

    private float explosionSize;

    public MessageExplode() //Empty constructor to avoid errors
    {

    }

    public MessageExplode(float explosionSize)
    {
        this.explosionSize = explosionSize;
    }

    @Override
    public void handleClientSide(MessageExplode message, EntityPlayer player)
    {

    }

    @Override
    public void handleServerSide(MessageExplode message, EntityPlayer player)
    {
        player.worldObj.createExplosion(player, player.posX, player.posY - 10, player.posZ, message.explosionSize, true);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        explosionSize = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(explosionSize);
    }
}
