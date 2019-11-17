package org.hmily.course.designpattern.strategy;

public class ConcreteStrategyA implements Strategy{


    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategyA");
    }
}
