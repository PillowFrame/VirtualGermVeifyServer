package com.omg.pf.client.netty.packet;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VerifyStatusPacket implements GermPacket {
    private static final List<String> Field1475 = new ArrayList<>();
    private static String Field1474 = "";
    private static String Field1476 = "";


    public void onReceive(ChannelHandlerContext var1) throws Exception {
        HandlerManager.getHandler().onReceivePacket(this, var1);
    }

    public void decode(GermByteBuf var1) {
        Field1474 = var1.readString();
        Field1476 = var1.readString();

        String[] var2 = var1.readString().split(";");
        int var3 = var2.length;

        int var4;
        String var5;
        for (var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            Field1475.add(var5.toLowerCase(Locale.ROOT));
        }

        var2 = var1.readString().split(";");
        var3 = var2.length;

        for (var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            Field1475.add(var5.toLowerCase(Locale.ROOT));
        }

    }

    public void encode(GermByteBuf var1) {
        var1.writeString(Field1474);
        var1.writeString(Field1476);
        StringBuilder sb = new StringBuilder();
        for (String s : Field1475) {
            sb.append(s).append(";");
        }
        var1.writeString(sb.toString());
//        不知道读两次是什么鬼
        var1.writeString(sb.toString());
    }
}
