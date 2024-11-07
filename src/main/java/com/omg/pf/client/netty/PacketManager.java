package com.omg.pf.client.netty;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.omg.pf.client.netty.packet.*;
import com.omg.pf.client.netty.packet.verify.*;
import com.omg.pf.netty.packet.GermPacket;
import io.netty.channel.Channel;

public class PacketManager {
    private static final BiMap<Integer, Class<? extends GermPacket>> packetIdMap = HashBiMap.create();
    private static int maxPacketID = 1;

    static {
        registerPacket(new ExchangeKeyPacket());
        registerPacket(new SecretInfoPacket());
        registerPacket(new ServerInfoReport());
        registerPacket(new VerifyInfosPacket());
        registerPacket(new PluginVerifySuccessPacket());
        registerPacket(new PluginTooMuchMachinePacket());
        registerPacket(new PluginTooMuchServerPacket());
        registerPacket(new PluginExpiredPacket());
        registerPacket(new PluginCDKWrongPacket());
        registerPacket(new VersionPacket());
        registerPacket(new VerifyStatusPacket());
        registerPacket(new ExtendPacketPacket());
    }

    public static BiMap<Integer, Class<? extends GermPacket>> getPacketIdMap() {
        return packetIdMap;
    }

    public static void sendPacket(Channel channel, GermPacket germPacket) {
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(germPacket);
        }
    }

    public static void registerPacket(GermPacket var0) {
        packetIdMap.put(maxPacketID++, var0.getClass());
    }
}
