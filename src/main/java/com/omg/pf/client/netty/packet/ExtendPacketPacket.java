package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class ExtendPacketPacket implements GermPacket {
    public boolean enable;
    public String packetName;

    public ExtendPacketPacket(boolean enable, String packetName) {
        this.enable = enable;
        this.packetName = packetName;
    }

    public ExtendPacketPacket() {

    }

    public void encode(GermByteBuf var1) {
        var1.writeString(this.packetName);
        var1.writeBoolean(this.enable);
    }

    public void decode(GermByteBuf var1) {
        this.packetName = var1.readString();
        this.enable = var1.readBoolean();
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
