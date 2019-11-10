package org.hmily.course.designpattern.factory.abstractfactory.pizzastore;

import org.hmily.course.designpattern.factory.abstractfactory.pizza.Pizza;

/**
 *  pizza store
 */
public abstract class PizzaStore {

    void orderPizza(String type){
        createPizza(type);
    }

    abstract Pizza createPizza(String type);

}
