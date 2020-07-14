package com.moon.middle.network.netty.nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/14 3:24 下午
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 4) { //2
            int value = Math.abs(in.readInt());//3
            out.add(value);  //4
        }
    }
}
