package org.hmily.rpc.proxy;

import org.hmily.rpc.netty.RemoteInvocationNettyHandler;

import java.lang.reflect.Proxy;

public class RpcProxyClient {


    public <T> T proxyClient(final Class<T> clz,final String host,final int port){
        return (T)Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{clz},new RemoteInvocationHandler(host,port));
    }


    public <T> T proxyNettyClient(final Class<T> clz,final String host,final int port){
        return (T)Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{clz},new RemoteInvocationNettyHandler(host,port));
    }

}
