package org.hmily.springboot.starter.service;

public class StringFormatServiceImpl implements FormatService{


    public <T> String formatString(T t) {
        return "StringFormatServiceImpl : " + t.toString();
    }
}
