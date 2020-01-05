package org.hmily.tomcat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;

public class MyRequest {

    private ChannelHandlerContext ctx;

    private HttpRequest req;

    public MyRequest(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx = ctx;
        this.req = req;
    }

    public String getUrl() {
        return req.uri();
    }

    public String getMethod() {
        return req.method().name();
    }
}
