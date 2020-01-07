package org.hmily.springboot.starter.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;


@ConfigurationProperties(prefix = TestProperties.TEST_PREFIX)
public class TestProperties {

    public static final String TEST_PREFIX = "mytest.starter.format";

    private Map<String,Object> info;

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
