package com.moon.middle.network.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/3 6:32 下午
 */
public class ByteBufDemo1 {
    public static void main(String[] args) {
        Channel channel = new NioSocketChannel();
        channel.alloc().buffer();

        ChannelPipeline channelPipeline = channel.pipeline();
        channelPipeline.context(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {

            }
        }).alloc();


        String f = ByteBufUtil.hexDump(channel.alloc().buffer());
    }
}
