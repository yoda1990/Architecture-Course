package org.hmily.course.designpattern.decorator;

public class DecoratorPatternDemo {


    public static void main(String[] args) {
           Beverage beverage = new DarkRost();
           System.out.println(beverage.getDescription());

           Beverage beverage1 = new HouseBlend();
           beverage1 = new Mocha(beverage1);
           System.out.println(beverage1.getDescription()+":"+beverage1.cost());
    }
}
