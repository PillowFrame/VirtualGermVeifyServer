package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.cipher.SecretKeyGenerator;
import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.security.PublicKey;

public class ExchangeKeyPacket implements GermPacket {
    public PublicKey publicKey;
    public byte[] verifyInfo;

    public ExchangeKeyPacket() {
    }

    public ExchangeKeyPacket(PublicKey publicKey, byte[] verifyInfo) {
        this.publicKey = publicKey;
        this.verifyInfo = verifyInfo;
    }

    public void encode(GermByteBuf var1) {
        var1.writeBytesGerm(this.publicKey.getEncoded());
        var1.writeBytesGerm(this.verifyInfo);
    }

    public void decode(GermByteBuf var1) {
        this.publicKey = SecretKeyGenerator.decodePublicKey(var1.readAllToByteArray());
        this.verifyInfo = var1.readAllToByteArray();
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
