package org.hmily.springboot.starter.service;

import com.alibaba.fastjson.JSON;

public class JsonFormatServiceImpl implements FormatService{

    public <T> String formatString(T t) {
        return "JsonFormatServiceImpl : " + JSON.toJSONString(t);
    }
}
