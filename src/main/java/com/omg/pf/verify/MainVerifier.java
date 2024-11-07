package com.omg.pf.verify;

import com.omg.pf.client.netty.packet.ExtendPacketPacket;
import com.omg.pf.client.netty.packet.VerifyInfosPacket;
import com.omg.pf.client.netty.packet.verify.PluginVerifySuccessPacket;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

public class MainVerifier {
    private final List<String> subModuleList = new ArrayList<>();

    public MainVerifier() {
        subModuleList.add("视频播放组件");
        subModuleList.add("基岩物品多匹配器");
        subModuleList.add("平滑过渡");
        subModuleList.add("客户端地图");
    }

    public void sendPluginVerifySuccess(ChannelHandlerContext ctx, VerifyInfosPacket packet) {
        PluginVerifySuccessPacket pluginVerifySuccessPacket = new PluginVerifySuccessPacket(0, 0, 0, "永不过期-好耶！", 0);
        pluginVerifySuccessPacket.setPlugin(packet.pluginName);
        pluginVerifySuccessPacket.setAuthor("Germ");
        pluginVerifySuccessPacket.setName("萌芽引擎完整版");
        pluginVerifySuccessPacket.setMessages(new ArrayList<>());
        ctx.writeAndFlush(pluginVerifySuccessPacket);
    }

    public void sendSubModelVerifySuccess(ChannelHandlerContext ctx) {
//        子模块
        for (String subModuleName : subModuleList) {
            ctx.writeAndFlush(new ExtendPacketPacket(true, subModuleName));
        }
    }
}
