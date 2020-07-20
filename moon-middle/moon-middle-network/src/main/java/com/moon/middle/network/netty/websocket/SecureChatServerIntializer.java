package com.moon.middle.network.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/17 10:09 上午
 */
public class SecureChatServerIntializer extends ChatServerInitializer{
    private final SslContext sslContext;

    public SecureChatServerIntializer(ChannelGroup channelGroup, SslContext sslContext) {
        super(channelGroup);
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        super.initChannel(channel);
        SSLEngine engine = sslContext.newEngine(channel.alloc());
        engine.setUseClientMode(false);
        channel.pipeline().addFirst(new SslHandler(engine));
    }
}
