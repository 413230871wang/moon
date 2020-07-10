package com.moon.middle.network.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/9 4:47 下午
 */
public class CmdHandlerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline channelPipeline = channel.pipeline();
        channelPipeline.addLast(new CmdDecoder(65*1024));
        channelPipeline.addLast(new CmdHandler());
    }

    public static final class Cmd{
        private final ByteBuf name;
        private final ByteBuf args;

        public Cmd(ByteBuf name, ByteBuf args) {
            this.name = name;
            this.args = args;
        }

        public ByteBuf name(){
            return name;
        }

        public ByteBuf args(){
            return args;
        }
    }

    public static final class CmdDecoder extends LineBasedFrameDecoder{

        public CmdDecoder(int maxLength) {
            super(maxLength);
        }

        @Override
        protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
            ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
            if(frame == null){
                return null;
            }
            int index = frame.indexOf(frame.readerIndex(),frame.writerIndex(),(byte)' ');
            return new Cmd(frame.slice(frame.readerIndex(),index),frame.slice(index+1,frame.writerIndex()));
        }
    }

    public static final class CmdHandler extends SimpleChannelInboundHandler<Cmd>{

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Cmd cmd) throws Exception {
            
        }
    }
}
