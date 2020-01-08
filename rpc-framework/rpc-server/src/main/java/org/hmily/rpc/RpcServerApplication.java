package org.hmily.rpc;

import org.hmily.rpc.proxy.RpcProxyServerByNetty;


public class RpcServerApplication {

    public static void main(String[] args) {
        //TestApi testApi = new TestApiImpl();
        //RpcProxyServer rpcProxyServer = new RpcProxyServer();
        //rpcProxyServer.publisher(testApi,8080);

        RpcProxyServerByNetty rpcProxyServerByNetty = new RpcProxyServerByNetty();
        rpcProxyServerByNetty.publisher(8080);

    }

}
