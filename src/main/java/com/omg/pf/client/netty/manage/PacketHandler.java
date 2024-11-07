package com.omg.pf.client.netty.manage;

import com.omg.pf.client.netty.packet.*;
import com.omg.pf.client.netty.packet.verify.*;
import io.netty.channel.ChannelHandlerContext;

public abstract class PacketHandler {
    public void onReceivePacket(PluginCDKWrongPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(PluginExpiredPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(PluginTooMuchMachinePacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(PluginTooMuchServerPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(PluginVerifySuccessPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(ExchangeKeyPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(ExtendPacketPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(SecretInfoPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(ServerInfoReport packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(VerifyInfosPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(VerifyStatusPacket packet, ChannelHandlerContext ctx) {

    }

    public void onReceivePacket(VersionPacket packet, ChannelHandlerContext ctx) {

    }
}
