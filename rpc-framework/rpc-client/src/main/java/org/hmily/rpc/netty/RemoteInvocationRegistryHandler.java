package org.hmily.rpc.netty;

import org.hmily.rpc.protocol.InvokerProtocol;
import org.hmily.rpc.registry.ServiceDiscovery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationRegistryHandler implements InvocationHandler {

    private ServiceDiscovery serviceDiscovery;

    public RemoteInvocationRegistryHandler(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        InvokerProtocol rpcRequest = new InvokerProtocol();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        Class<?>[] types = new Class<?>[]{args.getClass()};
        rpcRequest.setParamters(types);
        rpcRequest.setValues(args);
        RpcNetRegistryTransport rpcNetTransport = new RpcNetRegistryTransport(serviceDiscovery);
        Object result = rpcNetTransport.send(rpcRequest);
        return result;
    }
}
