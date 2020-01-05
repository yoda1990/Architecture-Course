package org.hmily.tomcat;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;

public class MyRequest {

    private String url;

    private String method;

    public MyRequest(InputStream inputStream) {
        // 拿到HTTP 协议内容
        String content = "";
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            if ((len = inputStream.read())>0){
                content = new String(buffer,0,len);
            }
            String line = content.split("\\n")[0];
            String[]  arr = line.split("\\s");
            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
