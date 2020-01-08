package org.hmily.rpc.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.hmily.rpc.protocol.InvokerProtocol;
import java.lang.reflect.Method;


public class ProcessHandlerByNetty extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol invokerProtocol = (InvokerProtocol) msg;
        if (RegistryHandler.REGISTRY_MAP.containsKey(invokerProtocol.getClassName())){
            Object service = RegistryHandler.REGISTRY_MAP.get(invokerProtocol.getClassName());
            Method method = service.getClass().getMethod(invokerProtocol.getMethodName(),invokerProtocol.getParamters());
            result = method.invoke(service,invokerProtocol.getValues());
        }
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Registry Exception !!!!" + cause.toString());
    }

}
