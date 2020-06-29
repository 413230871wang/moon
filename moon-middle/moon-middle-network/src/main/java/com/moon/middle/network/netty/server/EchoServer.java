package com.moon.middle.network.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @desc:TODO Server的启动类
 * @author:lay
 * @date:2020/6/28 6:12 下午
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
//        if(args.length != 1){
//            System.err.println("Usage:"+EchoServer.class.getSimpleName()+"<port>");
//            return;
//        }
        int port = 9001;
        new EchoServer(port).start();
    }

    private void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new EchoServerHandler());
                    System.out.println("我又创建了一个channel");
                }
            });
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName()+" started and listen on"+f.channel().localAddress());
            f.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
