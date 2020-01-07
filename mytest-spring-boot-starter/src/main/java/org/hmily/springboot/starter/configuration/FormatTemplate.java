package org.hmily.springboot.starter.configuration;


import org.hmily.springboot.starter.service.FormatService;

public class FormatTemplate {

    private FormatService formatService;

    private TestProperties testProperties;

    public FormatTemplate(FormatService formatService,TestProperties testProperties) {
        this.formatService = formatService;
        this.testProperties = testProperties;
    }

    public <T> String doFormat(T t){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("begin---").append("<br/>");
        stringBuilder.append("configuration-info : " + formatService.formatString(testProperties.getInfo())).append("<br/>");
        stringBuilder.append("input string : " +formatService.formatString(t));
        return stringBuilder.toString();
    }



}
