package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PluginExpiredPacket extends VerifyPluginResultPacket {
    public String Field1452;

    public PluginExpiredPacket() {
    }

    public PluginExpiredPacket(String var1) {
        this.Field1452 = var1;
    }

    public String getPluginName() {
        return this.plugin;
    }

    public String getMessage() {
        return String.valueOf((new StringBuilder()).insert(0, "&b插件 &7").append(this.name).append(" 已经在 &7").append(this.Field1452).append(" &c过期，导致验证失败。"));
    }

    public PluginExpiredPacket Method916(String var1) {
        this.Field1452 = var1;
        return this;
    }

    public void encode(GermByteBuf var1) {
        super.encode(var1);
        var1.writeString(this.Field1452);
    }

    public boolean isSuccess() {
        return false;
    }

    public void decode(GermByteBuf var1) {
        super.decode(var1);
        this.Field1452 = var1.readString();
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
