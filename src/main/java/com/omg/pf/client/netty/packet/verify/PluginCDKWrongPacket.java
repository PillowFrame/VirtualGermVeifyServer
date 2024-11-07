package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.client.netty.manage.HandlerManager;
import io.netty.channel.ChannelHandlerContext;

public class PluginCDKWrongPacket extends VerifyPluginResultPacket {
    public boolean isSuccess() {
        return false;
    }

    public String getMessage() {
        return String.valueOf((new StringBuilder()).insert(0, "&b插件 &7").append(this.name).append(" 的Cdk不是正确的，导致验证失败。"));
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
