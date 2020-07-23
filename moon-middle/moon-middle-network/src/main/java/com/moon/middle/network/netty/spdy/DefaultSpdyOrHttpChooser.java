package com.moon.middle.network.netty.spdy;

import org.eclipse.jetty.npn.NextProtoNego;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.handler.codec.spdy.SpdyOrHttpChooser;

import javax.net.ssl.SSLEngine;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/20 7:07 下午
 */
public class DefaultSpdyOrHttpChooser extends SpdyOrHttpChooser {
    public DefaultSpdyOrHttpChooser(int maxSpdyContentLength, int maxHttpContentLength) {
        super(maxSpdyContentLength, maxHttpContentLength);
    }

    @Override
    protected SelectedProtocol getProtocol(SSLEngine engine) {
        DefaultServerProvider provider = (DefaultServerProvider) NextProtoNego.get(engine);  //1
        String protocol = provider.getSelectedProtocol();
        if (protocol == null) {
            return SelectedProtocol.None; //2
        }
        switch (protocol) {
            case "spdy/3.1":
                return SelectedProtocol.SpdyVersion3_1; //4
            case "http/1.1":
                return SelectedProtocol.HttpVersion1_1; //5
            default:
                return SelectedProtocol.None; //6
        }
    }

    @Override
    protected ChannelUpstreamHandler createHttpRequestHandlerForHttp() {
        return null; //7
    }

    @Override
    protected ChannelUpstreamHandler createHttpRequestHandlerForSpdy() {
        return null;  //8
    }
}
