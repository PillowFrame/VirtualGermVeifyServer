package com.omg.pf.netty;

import com.omg.pf.MainServer;
import com.omg.pf.Switches;
import com.omg.pf.client.netty.cipher.DecryptCipher;
import com.omg.pf.client.netty.cipher.EncryptCipher;
import com.omg.pf.client.netty.cipher.SecretKeyGenerator;
import com.omg.pf.client.netty.manage.PacketHandler;
import com.omg.pf.client.netty.packet.*;
import com.omg.pf.verify.MainVerifier;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class ServerPacketHandler extends PacketHandler {
    KeyPair keyPair = SecretKeyGenerator.genPublicKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();
    MainVerifier mainVerifier = new MainVerifier();

    @Override
    public void onReceivePacket(SecretInfoPacket packet, ChannelHandlerContext ctx) {
        if (Switches.DEBUG_NETWORK) System.out.println("SecretInfoPacket");
//        byte[] decryptedKey = SecretKeyGenerator.decryptCipher(privateKey, packet.encryptedSecretKey);
        byte[] decryptedVerifyBytes = SecretKeyGenerator.decryptCipher(privateKey, packet.encryptedVerifyBytes);
        if (Arrays.equals(decryptedVerifyBytes, MainServer.exchangeKeyBytes)) {
            if (Switches.DEBUG_NETWORK) System.out.println("验证序列正常");
        } else {
            if (Switches.DEBUG_NETWORK) System.out.println("异常验证序列！");
            return;
        }
        SecretKey secretKey = SecretKeyGenerator.decryptSecretKey(privateKey, packet.encryptedSecretKey);
        ChannelPipeline pipeline = ctx.pipeline();
        pipeline.addFirst("encrypt", new EncryptCipher(secretKey));
        pipeline.addFirst("decrypt", new DecryptCipher(secretKey));
    }

    @Override
    public void onReceivePacket(ServerInfoReport packet, ChannelHandlerContext ctx) {
        if (Switches.DEBUG_NETWORK) {
            System.out.println("ServerInfoReport");
            System.out.println(packet.infoJson);
        }
    }

    @Override
    public void onReceivePacket(VerifyInfosPacket packet, ChannelHandlerContext ctx) {
        if (Switches.DEBUG_NETWORK) {
            System.out.println("VerifyInfosPacket-验证信息包");
            System.out.println("CDK：" + packet.cdk);
            System.out.println("机器码：" + packet.hwid);
            System.out.println("插件名：" + packet.pluginName);
        }
//        正常在这里回复
        mainVerifier.sendPluginVerifySuccess(ctx, packet);
        mainVerifier.sendSubModelVerifySuccess(ctx);
        System.out.println("VerifyInfosPacket-验证成功发送完成"+ctx.channel().remoteAddress());
    }


    @Override
    public void onReceivePacket(VerifyStatusPacket packet, ChannelHandlerContext ctx) {
        if (Switches.DEBUG_NETWORK) System.out.println("VerifyStatusPacket");
//        没有使用，未处理
    }

    @Override
    public void onReceivePacket(VersionPacket packet, ChannelHandlerContext ctx) {
        if (Switches.DEBUG_NETWORK) {
            System.out.println("VersionPacket");
            System.out.println(packet.Field1454);
            System.out.println("验证开始");
        }
        ctx.writeAndFlush(new ExchangeKeyPacket(publicKey, MainServer.exchangeKeyBytes));
//        ctx.channel().writeAndFlush(new PluginVerifySuccessPacket(0,0,0,"永不过期",0));
//        sendVerifySuccess(ctx);
    }
}
