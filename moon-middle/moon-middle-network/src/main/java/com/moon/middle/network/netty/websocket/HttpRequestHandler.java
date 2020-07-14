package com.moon.middle.network.netty.websocket;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/14 4:45 下午
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {//1
    private final String wsUrl;
    private static final File INDEX;

    public HttpRequestHandler(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    static {
        URL location = HttpRequestHandler.class.getProtectionDomain().getCodeSource().getLocation();
        try{
            String path = location.toURI()+"index.html";
            path = !path.contains("file:")?path:path.substring(5);
            INDEX = new File(path);
        }catch (URISyntaxException e){
            throw new IllegalStateException("Unable to locate index.html");
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        if(wsUrl.equalsIgnoreCase(fullHttpRequest.getUri())){
            channelHandlerContext.fireChannelRead(fullHttpRequest.retain());//2
        }else{
            if(HttpHeaders.is100ContinueExpected(fullHttpRequest)){
                send100Continue(channelHandlerContext);//3
            }

            RandomAccessFile file = new RandomAccessFile(INDEX,"r");//4

            HttpResponse response = new DefaultFullHttpResponse(fullHttpRequest.getProtocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaders.Names.CONTENT_TYPE,"text/html; charset=UTF-8");

            boolean keepAlive = HttpHeaders.isKeepAlive(fullHttpRequest);

            if(keepAlive){//5
                response.headers().set(HttpHeaders.Names.CONTENT_LENGTH,file.length());
                response.headers().set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
            }
            channelHandlerContext.write(response);//6

            if(channelHandlerContext.pipeline().get(SslHandler.class) == null){//7
                channelHandlerContext.write(new DefaultFileRegion(file.getChannel(),0,file.length()));
            }else{
                channelHandlerContext.write(new ChunkedNioFile(file.getChannel()));
            }
            ChannelFuture future = channelHandlerContext.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);//8
            if(!keepAlive){
                future.addListener(ChannelFutureListener.CLOSE);//9
            }
        }
    }

    private void send100Continue(ChannelHandlerContext channelHandlerContext) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.CONTINUE);
        channelHandlerContext.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
