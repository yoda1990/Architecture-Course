package org.hmily.tomcat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyTomcat {

    private static final int port = 8080;

    private ServerSocket serverSocket;

    private Map<String,MyServlet> servletMap = new HashMap<String,MyServlet>();

    private Properties webXml = new Properties();

    /**
     * 初始化 TOMCAT
     */
    private void init(){
        String WEB_INF = this.getClass().getResource("/").getPath();
        try {
            FileInputStream fileInputStream = new FileInputStream(WEB_INF + "web.properties");
            webXml.load(fileInputStream);
            for (Object k:webXml.keySet()){
                String key = k.toString();
                if (key.endsWith(".url")){
                    String servletName = key.replaceAll("\\.url$","");
                    String url = webXml.getProperty(key);
                    String className = webXml.getProperty(servletName+".className");
                    MyServlet myServlet = (MyServlet) Class.forName(className).newInstance();
                    servletMap.put(url,myServlet);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行 http请求逻辑
     * @param client
     * @throws IOException
     */
    private void process(Socket client) throws IOException {
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        MyRequest myRequest = new MyRequest(is);
        MyResponse myResponse = new MyResponse(os);
        String url = myRequest.getUrl();
        if (servletMap.containsKey(url)){
            servletMap.get(url).service(myRequest,myResponse);
        }else {
            myResponse.write("404-NOT FOUND");
        }
    }


    /**
     * 启动Tomcat
     */
    public void start(){
            init();
            EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap(); // (2)
                b.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class) // (3)
                        .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                            @Override
                            public void initChannel(SocketChannel ch){
                                ch.pipeline().addLast(new HttpResponseEncoder());
                                ch.pipeline().addLast(new HttpRequestDecoder());
                                ch.pipeline().addLast(new MyTomcatServerHandler());
                            }
                        })
                        .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                        .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
                // Bind and start to accept incoming connections.
                ChannelFuture f = b.bind(port).sync(); // (7)
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
    }


    /**
     * 服务处理
     */
    public static class MyTomcatServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }

}
