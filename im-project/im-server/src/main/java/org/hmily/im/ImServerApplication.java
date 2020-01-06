package org.hmily.im;

import io.netty.channel.socket.SocketChannel;
import org.hmily.im.beans.AskMsg;
import org.hmily.im.handler.NettyChannelMap;

import java.util.concurrent.TimeUnit;

public class ImServerApplication {

    public static void main(String[] args) throws InterruptedException {
        NettyServerBootstrap bootstrap = new NettyServerBootstrap(9999);
        while (true){
            SocketChannel channel=(SocketChannel) NettyChannelMap.get("001");
            if(channel!=null){
                AskMsg askMsg=new AskMsg(null);
                channel.writeAndFlush(askMsg);
            }
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
