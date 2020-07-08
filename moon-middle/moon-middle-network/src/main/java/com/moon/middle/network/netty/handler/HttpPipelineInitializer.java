package com.moon.middle.network.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/8 3:48 下午
 */
public class HttpPipelineInitializer extends ChannelInitializer<Channel> {

    private final boolean client;

    public HttpPipelineInitializer(boolean client) {
        this.client = client;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline channelPipeline = channel.pipeline();
        if(client){
            channelPipeline.addLast("decoder",new HttpResponseDecoder());
            channelPipeline.addLast("encoder",new HttpRequestEncoder());
        }else{
            channelPipeline.addLast("decoder", new HttpRequestDecoder());
            channelPipeline.addLast("encoder",new HttpResponseEncoder());
        }
    }
}
