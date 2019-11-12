package org.hmily.course.designpattern.singleton;


/**
 * 双重检查锁
 */
public class DoubleCheckLockSingleton {

    private volatile static DoubleCheckLockSingleton uniqueInstance;

    public static synchronized DoubleCheckLockSingleton getInstance(){
        if (uniqueInstance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new DoubleCheckLockSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}
