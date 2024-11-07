package com.omg.pf.client.netty.packet.verify;

public interface WithMessagePacket {
    String getAuthor();

    String getName();

    String getPluginName();

    boolean isSuccess();

    String getMessage();
}
