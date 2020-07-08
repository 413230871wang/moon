package com.moon.middle.network.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/3 4:04 下午
 */
public class ByteBufDemo {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        System.out.println(Unpooled.copiedBuffer("1234",utf8).writerIndex());
        ByteBuf byteBuf = Unpooled.copiedBuffer("1234567890",utf8);
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        byteBuf.getByte(1);
        byteBuf.writerIndex(13);
        System.out.println(byteBuf.capacity());
        System.out.println(byteBuf.maxCapacity());
        System.out.println(byteBuf.array());
        System.out.println(byteBuf.writerIndex());
        System.out.println(byteBuf.readerIndex(4));
        System.out.println(byteBuf.readerIndex(5));
        byteBuf.readBytes(Unpooled.copiedBuffer("1234",utf8));
        byteBuf.writeBytes(Unpooled.copiedBuffer("1234",utf8));
        System.out.println("forRachByte="+byteBuf.forEachByte(ByteBufProcessor.FIND_SEMI_COLON));
        System.out.println(byteBuf.writerIndex());
        byteBuf.writerIndex();
        System.out.println(byteBuf.readerIndex());
        byteBuf.clear();
        System.out.println(byteBuf.readerIndex());
        byteBuf.discardReadBytes();
        if(byteBuf.isReadable()){
            byteBuf.readByte();
        }
        byteBuf.forEachByte(ByteBufProcessor.FIND_CR);
        byteBuf.asReadOnly();
        byteBuf.order();
        byteBuf.slice();
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);

        ByteBuf sliced = buf.slice(0,14);
        System.out.println(sliced.toString(utf8));

        buf.setByte(0,(byte)'J');
        System.out.println(buf.getByte(0) == sliced.getByte(0));
    }
}
