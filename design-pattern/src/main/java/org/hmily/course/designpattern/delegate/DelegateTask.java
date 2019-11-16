package org.hmily.course.designpattern.delegate;

public class DelegateTask implements Task{

    private Task taskA;

    private Task taskB;

    public DelegateTask() {
        this.taskA = new ConcreteTaskA();
        this.taskB = new ConcreteTaskB();
    }

    @Override
    public void doSomething() {
            taskA.doSomething();
            taskB.doSomething();
    }
}
