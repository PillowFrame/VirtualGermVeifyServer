package com.omg.pf.client.netty.coder.decoder;

import com.google.common.collect.BiMap;
import com.omg.pf.client.netty.PacketManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class GermByteBuf2PacketDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        GermByteBuf germByteBuf = new GermByteBuf(msg);
        int packetID = germByteBuf.readInt();
        BiMap<Integer, Class<? extends GermPacket>> packetIdMap = PacketManager.getPacketIdMap();
        if (packetIdMap.containsKey(packetID)) {
            GermPacket var7 = (GermPacket) ((Class<?>) packetIdMap.get(packetID)).newInstance();
            var7.decode(germByteBuf);
            out.add(var7);
        }
    }
}
