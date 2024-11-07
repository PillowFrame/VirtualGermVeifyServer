package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.cipher.SecretKeyGenerator;
import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public class SecretInfoPacket implements GermPacket {
    public byte[] encryptedSecretKey = new byte[0];
    public byte[] encryptedVerifyBytes = new byte[0];

    public SecretInfoPacket() {
    }

    public SecretInfoPacket(SecretKey secretKey, PublicKey publicKey, byte[] bytes) {
        this.encryptedSecretKey = SecretKeyGenerator.encryptCipher(publicKey, secretKey.getEncoded());
        this.encryptedVerifyBytes = SecretKeyGenerator.encryptCipher(publicKey, bytes);
    }

    public void encode(GermByteBuf var1) {
        var1.writeBytesGerm(this.encryptedSecretKey);
        var1.writeBytesGerm(this.encryptedVerifyBytes);
    }

    public void decode(GermByteBuf var1) {
        this.encryptedSecretKey = var1.readBytesGerm(var1);
        this.encryptedVerifyBytes = var1.readBytesGerm(var1);
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }
}
