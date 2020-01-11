package org.hmily.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.hmily.dubbo.api.HelloService;


@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Dubbo say hello to " + name;
    }
}
