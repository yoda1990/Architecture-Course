package org.hmily.rpc.netty;

import org.hmily.rpc.dto.RpcRequest;
import org.hmily.rpc.protocol.InvokerProtocol;
import org.hmily.rpc.proxy.RpcNetTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationNettyHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationNettyHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        InvokerProtocol rpcRequest = new InvokerProtocol();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setValues(args);

        RpcNetNettyTransport rpcNetTransport = new RpcNetNettyTransport(host,port);
        Object result = rpcNetTransport.send(rpcRequest);
        return result;
    }
}
