package org.hmily.tomcat;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {

    //SocketChannel的封装
    private ChannelHandlerContext ctx;

    public MyResponse(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public void write(String s) throws IOException {
        try {
            if (s == null || s.length() == 0) {
                return;
            }
            // 设置 http协议及请求头信息
            FullHttpResponse response = new DefaultFullHttpResponse(
                    // 设置http版本为1.1
                    HttpVersion.HTTP_1_1,
                    // 设置响应状态码
                    HttpResponseStatus.OK,
                    // 将输出值写出 编码为UTF-8
                    Unpooled.wrappedBuffer(s.getBytes("UTF-8")));

            response.headers().set("Content-Type", "text/html;");
            ctx.write(response);
        } finally {
            ctx.flush();
            ctx.close();
        }
    }

}
