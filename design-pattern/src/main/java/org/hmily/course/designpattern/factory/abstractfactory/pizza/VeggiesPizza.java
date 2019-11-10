package org.hmily.course.designpattern.factory.abstractfactory.pizza;

import org.hmily.course.designpattern.factory.abstractfactory.PizzaIngredientFactory;
import org.hmily.course.designpattern.factory.abstractfactory.pizza.Pizza;

public class VeggiesPizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public VeggiesPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        pizzaIngredientFactory=pizzaIngredientFactory;
    }

    @Override
    void prepare() {

    }
}
