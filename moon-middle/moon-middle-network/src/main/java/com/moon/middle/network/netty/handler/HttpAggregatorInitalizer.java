package com.moon.middle.network.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/8 3:59 下午
 */
public class HttpAggregatorInitalizer extends ChannelInitializer<Channel> {

    public HttpAggregatorInitalizer(boolean client) {
        this.client = client;
    }

    private final boolean client;

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline channelPipeline = channel.pipeline();
        if(client){
            channelPipeline.addLast("codec",new HttpClientCodec());
        }else{
            channelPipeline.addLast("codec",new HttpServerCodec());
        }
        channelPipeline.addLast("addgegator",new HttpObjectAggregator(512*1024));
    }
}
