package org.hmily.rpc;

import org.hmily.rpc.registry.RpcRegistry;

public class RpcRegistryApplication {

    public static void main(String[] args) {

        RpcRegistry rpcRegistry = new RpcRegistry(8080);
        rpcRegistry.start();

    }

}
