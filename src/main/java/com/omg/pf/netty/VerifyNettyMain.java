package com.omg.pf.netty;

import com.omg.pf.MainServer;
import com.omg.pf.client.netty.coder.decoder.GermByteBuf2PacketDecoder;
import com.omg.pf.client.netty.coder.encoder.Packet2GermByteBufEncoder;
import com.omg.pf.netty.coder.decoder.ByteBuf2GermByteBufDecoder;
import com.omg.pf.netty.coder.encoder.ByteBuf2GermByteBufEncoder;
import com.omg.pf.netty.handler.ExceptionHandler;
import com.omg.pf.netty.handler.NettyHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class VerifyNettyMain {
    private ChannelFuture f;

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public void start() {
        try {
            System.out.println("验证服务器启动中");
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline()
//                                    .addLast("hex", new HexDump("Server"))
                                    .addLast(new ByteBuf2GermByteBufDecoder())
                                    .addLast(new ByteBuf2GermByteBufEncoder())
                                    .addLast(new GermByteBuf2PacketDecoder())
                                    .addLast(new Packet2GermByteBufEncoder())
                                    .addLast(new InboundHandler())
                                    .addLast(new NettyHandler())
                                    .addLast(new ExceptionHandler());
                        }
                    });
            f = b.bind(MainServer.ip, MainServer.port).sync();
            System.out.println("验证服务器启动完成");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isRunning() {
        return true;
    }

    public void stop() {
        System.out.println("Netty关闭中");
        try {
            f.channel().close().sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
        System.out.println("Netty关闭完成");
    }

}
