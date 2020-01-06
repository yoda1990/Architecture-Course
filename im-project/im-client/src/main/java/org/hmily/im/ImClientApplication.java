package org.hmily.im;

import org.hmily.im.base.AskParams;
import org.hmily.im.base.Constants;
import org.hmily.im.beans.AskMsg;
import org.hmily.im.beans.LoginMsg;

import java.util.concurrent.TimeUnit;

public class ImClientApplication {

    public static void main(String[] args) throws InterruptedException {
        Constants.setClientID("001");
        NettyClientBootstrap bootstrap = new NettyClientBootstrap(9999,"localhost");
        LoginMsg loginMsg=new LoginMsg();
        loginMsg.setPassword("yao");
        loginMsg.setUsername("robin");
        bootstrap.socketChannel.writeAndFlush(loginMsg);
        while (true){
            TimeUnit.SECONDS.sleep(30);
            AskParams askParams=new AskParams();
            askParams.setAuth("authToken");
            AskMsg askMsg=new AskMsg(askParams);
            bootstrap.socketChannel.writeAndFlush(askMsg);
        }
    }

}
