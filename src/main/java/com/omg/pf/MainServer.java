package com.omg.pf;

import com.omg.pf.client.netty.manage.HandlerManager;
import com.omg.pf.netty.ServerPacketHandler;
import com.omg.pf.netty.VerifyNettyMain;


public class MainServer {
    public static final byte[] exchangeKeyBytes = {-98, -32, -16, -16};
    public static String ip = "0.0.0.0";
    public static int port = 29976;
    private static VerifyNettyMain verifyNettyMain;

    public static void main(String[] var0) {
        HandlerManager.registerHandler(new ServerPacketHandler());
        verifyNettyMain = new VerifyNettyMain();
        verifyNettyMain.start();
    }

}
