package com.omg.pf.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public class ExceptionHandler implements ChannelHandler {
    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        if (throwable instanceof IOException) {
            return;
        }
        throwable.printStackTrace();
    }
}
