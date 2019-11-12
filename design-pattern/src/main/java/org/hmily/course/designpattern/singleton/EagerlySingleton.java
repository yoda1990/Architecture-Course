package org.hmily.course.designpattern.singleton;


/**
 * 饿汉式
 */
public class EagerlySingleton {

    private static EagerlySingleton uniqueInstance = new EagerlySingleton();

    public static EagerlySingleton getInstance(){
        return uniqueInstance;
    }

}
