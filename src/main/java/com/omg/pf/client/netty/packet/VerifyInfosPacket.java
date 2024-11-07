package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class VerifyInfosPacket implements GermPacket {
    public String pluginName;
    public String cdk;
    public String hwid;

    public VerifyInfosPacket(String pluginName, String cdk, String hwid) {
        this.pluginName = pluginName;
        this.cdk = cdk;
        this.hwid = hwid;
    }

    public VerifyInfosPacket() {
    }

    public void decode(GermByteBuf var1) {
        this.pluginName = var1.readString();
        this.cdk = var1.readString();
        this.hwid = var1.readString();
    }

    public void encode(GermByteBuf var1) {
        var1.writeString(this.pluginName);
        var1.writeString(this.cdk);
        var1.writeString(this.hwid);
    }


    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
