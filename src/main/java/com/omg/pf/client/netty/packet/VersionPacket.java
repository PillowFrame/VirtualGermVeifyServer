package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class VersionPacket implements GermPacket {
    public String Field1454;

    public VersionPacket() {
    }

    public VersionPacket(String var1) {
        this.Field1454 = var1;
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }


    public void decode(GermByteBuf var1) {
        Field1454 = var1.readString();

    }

    public void encode(GermByteBuf var1) {
        var1.writeString(this.Field1454);
    }
}
