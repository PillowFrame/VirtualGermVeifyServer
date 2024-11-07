package com.omg.pf.client.netty.cipher;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.security.Key;

public class EncryptCipher extends MessageToByteEncoder<ByteBuf> {
    private final EncryptUtil Field1285;

    public EncryptCipher(Key var1) {
        this.Field1285 = new EncryptUtil(SecretKeyGenerator.getCipher(1, var1));
    }

    @Override
    public void encode(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws Exception {
        this.Field1285.encrypt(var2, var3);
    }
}
