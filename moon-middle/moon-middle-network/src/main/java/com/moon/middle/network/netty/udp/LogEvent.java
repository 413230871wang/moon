package com.moon.middle.network.netty.udp;

import java.net.InetSocketAddress;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/21 3:46 下午
 */
public class LogEvent {
    public static final byte SEPARATOR = (byte)':';
    private final InetSocketAddress source;
    private final String msg;
    private final long received;
    private final String logfile;

    public LogEvent(String msg, String logfile) {
        this(null, -1, logfile, msg);
    }

    public LogEvent(InetSocketAddress source, long received, String logfile, String msg) {
        this.source = source;
        this.msg = msg;
        this.received = received;
        this.logfile = logfile;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceivedTimestamp() {
        return received;
    }

    public String getLogfile() {
        return logfile;
    }
}
