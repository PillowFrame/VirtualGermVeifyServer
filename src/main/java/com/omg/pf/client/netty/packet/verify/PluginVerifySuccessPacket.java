package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PluginVerifySuccessPacket extends VerifyPluginResultPacket {
    public int limitAmountServer;
    public int onlinePC;
    public int onlineServer;
    public String overdueDate;
    public int limitAmountPC;

    public PluginVerifySuccessPacket(int limitAmountServer, int onlinePC, int onlineServer, String overdueDate, int limitAmountPC) {
        this.limitAmountServer = limitAmountServer;
        this.onlinePC = onlinePC;
        this.onlineServer = onlineServer;
        this.overdueDate = overdueDate;
        this.limitAmountPC = limitAmountPC;
    }

    public PluginVerifySuccessPacket() {
    }

    public String toString() {
        return (new StringBuilder()).insert(0, "Success(super=").append(super.toString()).append(", onlinePC=").append(this.onlinePC).append(", limitAmountPC=").append(this.limitAmountPC).append(", onlineServer=").append(this.onlineServer).append(", limitAmountServer=").append(this.limitAmountServer).append(", overdueDate=").append(this.overdueDate).append(")").toString();
    }

    public boolean isSuccess() {
        return true;
    }

    public PluginVerifySuccessPacket Method947(int var1) {
        this.onlinePC = var1;
        return this;
    }

    public String getMessage() {
        return (new StringBuilder()).insert(0, "&b插件 &7").append(this.name).append(" &b验证成功~ 还可以登录 &7").append(this.Method952()).append(" &b台机器、&7").append(this.Method950()).append(" &b个服务端，将于 &7").append(this.overdueDate).append(" &b过期").toString();
    }

    // $FF: synthetic method
    private String Method950() {
        return this.limitAmountServer == 0 ? "无限" : this.limitAmountServer - this.onlineServer + "";
    }

    public void decode(GermByteBuf var1) {
        super.decode(var1);
        this.onlinePC = var1.readInt();
        this.limitAmountPC = var1.readInt();
        this.onlineServer = var1.readInt();
        this.limitAmountServer = var1.readInt();
        this.overdueDate = var1.readString();
    }

    public void encode(GermByteBuf var1) {
        super.encode(var1);
        var1.writeInt(this.onlinePC);
        var1.writeInt(this.limitAmountPC);
        var1.writeInt(this.onlineServer);
        var1.writeInt(this.limitAmountServer);
        var1.writeString(this.overdueDate);
    }

    // $FF: synthetic method
    private String Method952() {
        return this.limitAmountPC == 0 ? "无限" : this.limitAmountPC - this.onlinePC + "";
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
