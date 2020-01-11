package org.hmily.dubbo.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.hmily.dubbo.api.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Reference(check = false)
    HelloService helloService;


    @RequestMapping("/hello")
    public String sayHello(){
        return helloService.sayHello("Hmily");
    }
}
