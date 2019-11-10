package org.hmily.course.designpattern.factory.abstractfactory.pizza;

import org.hmily.course.designpattern.factory.abstractfactory.PizzaIngredientFactory;

public class ClamsPizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamsPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        clams = pizzaIngredientFactory.createClam();


    }
}
