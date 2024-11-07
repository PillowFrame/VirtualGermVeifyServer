package com.omg.pf.client.netty.cipher;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class EncryptUtil {
    private final Cipher Field1424;
    private byte[] Field1422 = new byte[0];
    private byte[] Field1423 = new byte[0];

    public EncryptUtil(Cipher var1) {
        this.Field1424 = var1;
    }

    // $FF: synthetic method
    private byte[] byteBufDataRead(ByteBuf var1) {
        int var2 = var1.readableBytes();
        if (this.Field1422.length < var2) {
            this.Field1422 = new byte[var2];
        }

        var1.readBytes(this.Field1422, 0, var2);
        return this.Field1422;
    }

    public void encrypt(ByteBuf var1, ByteBuf var2) throws ShortBufferException {
        int var3 = var1.readableBytes();
        byte[] var4 = this.byteBufDataRead(var1);
        int var5 = this.Field1424.getOutputSize(var3);
        if (this.Field1423.length < var5) {
            this.Field1423 = new byte[var5];
        }

        var2.writeBytes(this.Field1423, 0, this.Field1424.update(var4, 0, var3, this.Field1423));
    }

    public ByteBuf decrypt(ChannelHandlerContext var1, ByteBuf var2) throws ShortBufferException {
        int var3 = var2.readableBytes();
        byte[] var4 = this.byteBufDataRead(var2);
        ByteBuf var5 = var1.alloc().heapBuffer(this.Field1424.getOutputSize(var3));
        var5.writerIndex(this.Field1424.update(var4, 0, var3, var5.array(), var5.arrayOffset()));
        return var5;
    }
}
