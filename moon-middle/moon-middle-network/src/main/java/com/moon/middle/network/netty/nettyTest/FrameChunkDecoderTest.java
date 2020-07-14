package com.moon.middle.network.netty.nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/14 4:10 下午
 */
public class FrameChunkDecoderTest {
    @Test    //1
    public void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer();  //2
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));  //3
        Assert.assertTrue(channel.writeInbound(input.readBytes(2)));  //4
        try {
            channel.writeInbound(input.readBytes(4)); //5
            Assert.fail();  //6
        } catch (TooLongFrameException e) {
            // expected
            System.out.println("出错了");
        }
        Assert.assertTrue(channel.writeInbound(input.readBytes(3)));  //7


        Assert.assertTrue(channel.finish());  //8

        ByteBuf read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(2), read); //9
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.skipBytes(4).readSlice(3), read);
        read.release();

        buf.release();
    }
}
