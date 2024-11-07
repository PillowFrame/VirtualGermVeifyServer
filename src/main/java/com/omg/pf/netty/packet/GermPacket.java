package com.omg.pf.netty.packet;

import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

public interface GermPacket {
    void onReceive(ChannelHandlerContext var1) throws Exception;

    void decode(GermByteBuf var1);

    void encode(GermByteBuf var1);
}
