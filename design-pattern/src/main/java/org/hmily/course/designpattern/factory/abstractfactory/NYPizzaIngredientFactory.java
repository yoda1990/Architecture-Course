package org.hmily.course.designpattern.factory.abstractfactory;

import org.hmily.course.designpattern.factory.abstractfactory.ingredient.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{


    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoChees();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies vigges[] = {new Garlica(),new Onion(),new Mushroom(),new RedPepper()};
        return vigges;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
