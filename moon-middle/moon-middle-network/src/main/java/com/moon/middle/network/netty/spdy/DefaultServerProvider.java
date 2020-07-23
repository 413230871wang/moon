package com.moon.middle.network.netty.spdy;

import org.eclipse.jetty.npn.NextProtoNego;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/20 4:14 下午
 */
public class DefaultServerProvider implements NextProtoNego.ServerProvider {
    private static final List<String> PROTOCOLS = Collections.unmodifiableList(Arrays.asList("spdy/2",
            "spdy/3","http/1.1"));

    private String protocol;

    @Override
    public void unsupported() {
        protocol = "http/1.1";
    }

    @Override
    public List<String> protocols() {
        return PROTOCOLS;
    }

    @Override
    public void protocolSelected(String s) {
        this.protocol = protocol;
    }

    public String getSelectedProtocol() {
        return protocol;
    }
}
