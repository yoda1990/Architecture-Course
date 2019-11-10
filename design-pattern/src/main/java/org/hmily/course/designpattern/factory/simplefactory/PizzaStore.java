package org.hmily.course.designpattern.factory.simplefactory;


/**
 *  pizza store
 */
public class PizzaStore {

    PizzaSampleFactory factory;

    public PizzaStore(PizzaSampleFactory factory) {
        this.factory = factory;
    }

    public static Pizza orderPizza(String type){
        PizzaSampleFactory pizzaSampleFactory = new PizzaSampleFactory();
        Pizza pizza =pizzaSampleFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
