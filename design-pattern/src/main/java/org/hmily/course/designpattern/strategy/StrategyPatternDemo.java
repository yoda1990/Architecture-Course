package org.hmily.course.designpattern.strategy;

public class StrategyPatternDemo {


    public static void main(String[] args) {
           new Context(new ConcreteStrategyA()).doSomething();
    }

}
