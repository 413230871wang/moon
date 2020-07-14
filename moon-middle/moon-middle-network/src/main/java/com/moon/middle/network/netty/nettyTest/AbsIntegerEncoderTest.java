package com.moon.middle.network.netty.nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

import java.util.jar.JarOutputStream;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/14 3:24 下午
 */
public class AbsIntegerEncoderTest {
    @Test   //1
    public void testEncoded() {
        ByteBuf buf = Unpooled.buffer();  //2
        for (int i = 1; i < 10; i++) {
            buf.writeInt(i * -1);
        }

        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());  //3
        Assert.assertTrue(channel.writeOutbound(buf)); //4

        Assert.assertTrue(channel.finish()); //5
        for (int i = 1; i < 10; i++) {
            System.out.println((int)channel.readOutbound());
//            Assert.assertEquals(i, (int)channel.readOutbound());  //6
        }
        Assert.assertNull(channel.readOutbound());
    }
}
