package org.hmily.rpc.service;

import org.hmily.rpc.api.TestApi;

public class TestApiImpl implements TestApi {

    public String sayHello(String name) {
        return "Hello," + name;
    }
}
