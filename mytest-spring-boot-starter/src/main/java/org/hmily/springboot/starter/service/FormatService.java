package org.hmily.springboot.starter.service;

public interface FormatService {

    /**
     * 格式化数据
     * @param t
     * @param <T>
     * @return
     */
    <T> String formatString(T t);
}
