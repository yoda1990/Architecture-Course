package org.hmily.course.designpattern.singleton;


/**
 * 普通的单例模式
 * 懒汉式
 */
public class Singleton {

    private static Singleton uniqueInstance;

    public static synchronized Singleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
            return uniqueInstance;
        }
        return uniqueInstance;
    }

}
