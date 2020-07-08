package com.moon.middle.network.netty.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/7 6:43 下午
 */
class SSlHandler extends ChannelInitializer<Channel> {

    private final SslContext context;
    private final boolean startTls;

    public SSlHandler(SslContext context, boolean startTls) {
        this.context = context;
        this.startTls = startTls;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        SSLEngine sslEngine = context.newEngine(channel.alloc());
        sslEngine.setUseClientMode(true);
        channel.pipeline().addFirst("ssl",new SslHandler(sslEngine,startTls));
    }
}
