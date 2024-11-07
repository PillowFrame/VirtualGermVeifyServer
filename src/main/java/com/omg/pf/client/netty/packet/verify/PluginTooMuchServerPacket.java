package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PluginTooMuchServerPacket extends VerifyPluginResultPacket {
    public int Field1231;
    public int Field1232;

    public PluginTooMuchServerPacket(int var1, int var2) {
        this.Field1231 = var1;
        this.Field1232 = var2;
    }

    public PluginTooMuchServerPacket() {
    }

    public String getMessage() {
        return (new StringBuilder()).insert(0, "&b插件 &7").append(this.name).append(" 已经登录了 &7").append(this.Field1231).append(" &c个服务端，超过了限制 &7").append(this.Field1232).append(" &c个，导致验证失败。").toString();
    }

    public PluginTooMuchServerPacket Method817(int var1) {
        this.Field1231 = var1;
        return this;
    }

    public boolean isSuccess() {
        return false;
    }

    public PluginTooMuchServerPacket Method819(int var1) {
        this.Field1232 = var1;
        return this;
    }

    public void encode(GermByteBuf var1) {
        super.encode(var1);
        var1.writeInt(this.Field1231);
        var1.writeInt(this.Field1232);
    }

    public void decode(GermByteBuf var1) {
        super.decode(var1);
        this.Field1231 = var1.readInt();
        this.Field1232 = var1.readInt();
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
