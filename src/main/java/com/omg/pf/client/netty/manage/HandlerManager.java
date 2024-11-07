package com.omg.pf.client.netty.manage;

public class HandlerManager {
    private static PacketHandler handler;

    public static PacketHandler getHandler() {
        return handler;
    }

    public static void registerHandler(PacketHandler handler) {
        HandlerManager.handler = handler;
    }
}
