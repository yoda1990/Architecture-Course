package org.hmily.rpc;

import org.hmily.rpc.api.TestApi;
import org.hmily.rpc.proxy.RpcProxyServer;
import org.hmily.rpc.service.TestApiImpl;

public class RpcServerApplication {

    public static void main(String[] args) {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        TestApi testApi = new TestApiImpl();
        rpcProxyServer.publisher(testApi,8080);
    }

}
