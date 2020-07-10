package com.moon.middle.network.netty.handler;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/9 5:24 下午
 */
public class FileRegionDemo {
    public static void main(String[] args) {
        Channel channel = new NioSocketChannel();
        File file = new File("");
        FileInputStream fis = null;

        {
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        FileRegion region = new DefaultFileRegion(fis.getChannel(),0,file.length());
        channel.writeAndFlush(region).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(!channelFuture.isSuccess()){
                    Throwable cause = channelFuture.cause();
                }
            }
        });
    }
}
