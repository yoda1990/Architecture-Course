package org.hmily.springboot.starter.configuration;

import org.hmily.springboot.starter.service.JsonFormatServiceImpl;
import org.hmily.springboot.starter.service.StringFormatServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FormatAutoConfiguration {

    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    @Bean
    @Primary
    public StringFormatServiceImpl stringFormat(){
        return new StringFormatServiceImpl();
    }

    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    @Bean
    public JsonFormatServiceImpl jsonFormat(){
        return new JsonFormatServiceImpl();
    }


}
