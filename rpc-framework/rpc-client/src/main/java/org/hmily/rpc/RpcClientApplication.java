package org.hmily.rpc;

import org.hmily.rpc.api.TestApi;
import org.hmily.rpc.proxy.RpcProxyClient;

public class RpcClientApplication {

    public static void main(String[] args) {
        RpcProxyClient proxyClient = new RpcProxyClient();
        TestApi testApi = proxyClient.proxyClient(TestApi.class,"localhost",8080);
        String  result = testApi.sayHello("Hmily");
        System.out.println(result);

    }

}
