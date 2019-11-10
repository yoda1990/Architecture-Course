package org.hmily.course.designpattern.factory.abstractfactory.pizzastore;

import org.hmily.course.designpattern.factory.abstractfactory.NYPizzaIngredientFactory;
import org.hmily.course.designpattern.factory.abstractfactory.PizzaIngredientFactory;
import org.hmily.course.designpattern.factory.abstractfactory.pizza.CheesePizza;
import org.hmily.course.designpattern.factory.abstractfactory.pizza.ClamsPizza;
import org.hmily.course.designpattern.factory.abstractfactory.pizza.Pizza;
import org.hmily.course.designpattern.factory.abstractfactory.pizza.VeggiesPizza;

public class NYPizzaStore extends PizzaStore {

    

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        }else if (type.equals("veggies")){
            pizza = new VeggiesPizza(pizzaIngredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }else if (type.equals("clam")){
            pizza = new ClamsPizza(pizzaIngredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }else if (type.equals("pepperoni")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
