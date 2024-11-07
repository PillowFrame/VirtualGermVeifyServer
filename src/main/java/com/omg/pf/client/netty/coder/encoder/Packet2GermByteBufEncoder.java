package com.omg.pf.client.netty.coder.encoder;

import com.google.common.collect.BiMap;
import com.omg.pf.client.netty.PacketManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Packet2GermByteBufEncoder extends MessageToByteEncoder<GermPacket> {
    @Override
    public void encode(ChannelHandlerContext ctx, GermPacket packet, ByteBuf out) throws Exception {
        BiMap<Integer, Class<? extends GermPacket>> packetIdMap = PacketManager.getPacketIdMap();
        Class<? extends GermPacket> packetClass = packet.getClass();
        if (packetIdMap.containsValue(packetClass)) {
            int packetID = packetIdMap.inverse().get(packetClass);
            GermByteBuf germByteBuf = new GermByteBuf(out);
            germByteBuf.writeInt(packetID);
            packet.encode(germByteBuf);
        }

    }

}
