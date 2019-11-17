package org.hmily.course.designpattern.strategy;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething(){
        strategy.doSomething();
    }
}
