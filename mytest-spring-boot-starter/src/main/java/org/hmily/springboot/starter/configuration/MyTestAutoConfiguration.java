package org.hmily.springboot.starter.configuration;


import org.hmily.springboot.starter.service.FormatService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(TestProperties.class)
@Configuration
public class MyTestAutoConfiguration {

    @Bean
    public FormatTemplate getFormatTemplate(FormatService formatService,TestProperties testProperties){
        return new FormatTemplate(formatService,testProperties);
    }

}
