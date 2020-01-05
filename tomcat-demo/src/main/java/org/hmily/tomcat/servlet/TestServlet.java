package org.hmily.tomcat.servlet;

import org.hmily.tomcat.MyRequest;
import org.hmily.tomcat.MyResponse;
import org.hmily.tomcat.MyServlet;

import java.io.OutputStream;

public class TestServlet extends MyServlet {


    @Override
    public void doGet(MyRequest request, MyResponse response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("Hello,welcome to here !");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
