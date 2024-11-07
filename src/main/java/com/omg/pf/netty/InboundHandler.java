package com.omg.pf.netty;

import com.omg.pf.netty.packet.GermPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class InboundHandler extends SimpleChannelInboundHandler<GermPacket> {
    @Override
    public void channelRead0(ChannelHandlerContext var1, GermPacket var2) throws Exception {
        var2.onReceive(var1);
    }

}
