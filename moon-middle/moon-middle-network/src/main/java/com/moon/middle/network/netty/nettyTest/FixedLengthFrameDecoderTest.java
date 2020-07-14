package com.moon.middle.network.netty.nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/14 11:06 上午
 */
public class FixedLengthFrameDecoderTest {
    @Test
    public void testFramesDecoded(){
        ByteBuf buf = Unpooled.buffer();
        for(int i = 0;i < 9;i++){
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        Assert.assertFalse(channel.writeInbound(input.readBytes(2)));
        Assert.assertTrue(channel.writeInbound(input.readBytes(7)));

        Assert.assertTrue(channel.finish());
        ByteBuf read = (ByteBuf) channel.readInbound();
        System.out.println("1:"+read.array());
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        System.out.println("2:"+read.array());
        Assert.assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        System.out.println("3:"+read.array());
        Assert.assertEquals(buf.readSlice(3), read);
        read.release();

        Assert.assertNull(channel.readInbound());
        buf.release();
    }

}
