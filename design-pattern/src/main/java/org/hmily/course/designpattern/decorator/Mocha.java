package org.hmily.course.designpattern.decorator;

public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.description + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost()+ 0.2;
    }
}
