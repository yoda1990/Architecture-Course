package org.hmily.course.designpattern.factory.factorymethod;

/**
 *  pizza store
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza =createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);

}
