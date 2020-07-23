package com.moon.middle.network.netty.spdy;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/20 6:58 下午
 */
public class SpdyRequestHandler extends HttpRequestHandler{
    @Override
    protected String getContent() {
        return "This content is transmitted via SPDY\r\n";
    }
}
