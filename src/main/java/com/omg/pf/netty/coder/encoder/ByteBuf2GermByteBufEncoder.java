package com.omg.pf.netty.coder.encoder;

import com.omg.pf.netty.util.GermByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@Sharable
public class ByteBuf2GermByteBufEncoder extends MessageToByteEncoder<ByteBuf> {
    @Override
    public void encode(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws Exception {
        int var4 = var2.readableBytes();
        int var5 = GermByteBuf.Method907(var4);
        if (var5 > 3) {
            throw new IllegalArgumentException(String.valueOf((new StringBuilder()).insert(0, "unable to fit ").append(var4).append(" into ").append(3)));
        } else {
            GermByteBuf var6 = new GermByteBuf(var3);
            var6.ensureWritable(var5 + var4);
            var6.writeVarInt(var4);
            var6.writeBytes(var2, var2.readerIndex(), var4);
        }
    }
}
