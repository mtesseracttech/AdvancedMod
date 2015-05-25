package com.mtesseract.advancedmod.network;

import com.mtesseract.advancedmod.AdvancedMod;
import com.mtesseract.advancedmod.reference.Reference;
import com.mtesseract.advancedmod.tileentity.TileEntityAdvancedMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 15-05-15
 * Time: 15:21
 */
@ChannelHandler.Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>
{
    public static final String CHANNEL = Reference.MOD_ID + "Description";

    public static void initialize()
    {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception
    {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = AdvancedMod.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
        if(te instanceof TileEntityAdvancedMod)
        {
            ((TileEntityAdvancedMod)te).readFromPacket(buf);
        }
    }
}
