package org.hmily.tomcat;

public class TomcatApplication {
    public static void main(String[] args) {
        MyTomcat myTomcat = new MyTomcat();
        myTomcat.start();
    }
}
