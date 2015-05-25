package com.mtesseract.advancedmod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 24-05-15
 * Time: 17:23
 */
public abstract class MessageXYZ<REQ extends IMessage> extends MessageBase<REQ>
{
    protected int x, y, z;

    public MessageXYZ()
    {
    }

    public MessageXYZ(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MessageXYZ(TileEntity te)
    {
        this(te.xCoord, te.yCoord, te.zCoord);
    }

    public void fromBytes(ByteBuf buf)
    {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    protected TileEntity getTileEntity(World world)
    {
        return world.getTileEntity(x, y, z);
    }
}
