package com.omg.pf.client.netty.cipher;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.security.Key;
import java.util.List;

public class DecryptCipher extends MessageToMessageDecoder<ByteBuf> {
    private final EncryptUtil Field1876;

    public DecryptCipher(Key var1) {
        this.Field1876 = new EncryptUtil(SecretKeyGenerator.getCipher(2, var1));
    }

    @Override
    public void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
        var3.add(this.Field1876.decrypt(var1, var2));
    }
}
