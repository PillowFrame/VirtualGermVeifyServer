package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PluginTooMuchMachinePacket extends VerifyPluginResultPacket {
    public int Field1326;
    public int Field1327;

    public PluginTooMuchMachinePacket(int var1, int var2) {
        this.Field1326 = var1;
        this.Field1327 = var2;
    }

    public PluginTooMuchMachinePacket() {
    }

    public PluginTooMuchMachinePacket Method847(int var1) {
        this.Field1327 = var1;
        return this;
    }

    public PluginTooMuchMachinePacket Method848(int var1) {
        this.Field1326 = var1;
        return this;
    }

    public String getMessage() {
        return (new StringBuilder()).insert(0, "&b插件 &7").append(this.name).append(" 已经登录了 &7").append(this.Field1326).append(" &c台机器，超过了限制 &7").append(this.Field1327).append(" &c台，导致验证失败。").toString();
    }

    public void encode(GermByteBuf var1) {
        super.encode(var1);
        var1.writeInt(this.Field1326);
        var1.writeInt(this.Field1327);
    }

    public void decode(GermByteBuf var1) {
        super.decode(var1);
        this.Field1326 = var1.readInt();
        this.Field1327 = var1.readInt();
    }

    public boolean isSuccess() {
        return false;
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
