package org.hmily.im.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.hmily.im.base.BaseMsg;
import org.hmily.im.base.MsgType;
import org.hmily.im.beans.*;

public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        NettyChannelMap.remove((SocketChannel)ctx.channel());

    }

    protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        if(MsgType.LOGIN.equals(baseMsg.getMsgType())){
            LoginMsg loginMsg=(LoginMsg)baseMsg;
            if("robin".equals(loginMsg.getUsername())&&"yao".equals(loginMsg.getPassword())){
                //登录成功,把channel存到服务端的map中
                NettyChannelMap.add(loginMsg.getClientID(),(SocketChannel)channelHandlerContext.channel());
                System.out.println("client"+loginMsg.getClientID()+" 登录成功");
            }
        }else{
            if(NettyChannelMap.get(baseMsg.getClientID())==null){
                //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
                LoginMsg loginMsg=new LoginMsg();
                channelHandlerContext.channel().writeAndFlush(loginMsg);
            }
        }

        switch (baseMsg.getMsgType()){
            case PING:{
                PingMsg pingMsg=(PingMsg)baseMsg;
                PingMsg replyPing=new PingMsg();
                NettyChannelMap.get(pingMsg.getClientID()).writeAndFlush(replyPing);
                System.out.println("receiver msg"+ pingMsg.toString());
            }break;
            case ASK:{
                //收到客户端的请求
                AskMsg askMsg=(AskMsg)baseMsg;
                if("authToken".equals(askMsg.getParams().getAuth())){
                    ReplyServerBody replyBody=new ReplyServerBody("server info $$$$ !!!");
                    ReplyMsg replyMsg=new ReplyMsg();
                    replyMsg.setBody(replyBody);
                    NettyChannelMap.get(askMsg.getClientID()).writeAndFlush(replyMsg);
                }

            }break;
            case REPLY:{
                //收到客户端回复
                ReplyMsg replyMsg=(ReplyMsg)baseMsg;
                ReplyClientBody clientBody=(ReplyClientBody)replyMsg.getBody();
                System.out.println("receive client msg: "+clientBody.getClientInfo());

            }break;
            default:break;
        }
        ReferenceCountUtil.release(baseMsg);
    }

    protected void channelRead0(ChannelHandlerContext arg0, BaseMsg arg1) throws Exception {
        messageReceived(arg0,arg1);

    }
}
