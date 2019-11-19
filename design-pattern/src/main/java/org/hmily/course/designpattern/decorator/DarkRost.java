package org.hmily.course.designpattern.decorator;

public class DarkRost extends Beverage{


    public DarkRost() {
        description = "DarkRost";
    }

    @Override
    public double cost() {
        return 1.2;
    }


}
