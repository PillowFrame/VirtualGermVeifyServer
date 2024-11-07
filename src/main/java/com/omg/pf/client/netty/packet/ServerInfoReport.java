package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class ServerInfoReport implements GermPacket {
    public String infoJson;

    public ServerInfoReport() {
    }

    public ServerInfoReport(String infoJson) {
        this.infoJson = infoJson;
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }

    public void decode(GermByteBuf var1) {
        this.infoJson = var1.readString();
    }

    public void encode(GermByteBuf var1) {
        var1.writeString(this.infoJson);
    }
}
