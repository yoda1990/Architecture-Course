package org.hmily.course.designpattern.factory.abstractfactory.pizza;

import org.hmily.course.designpattern.factory.abstractfactory.ingredient.*;

import java.util.Arrays;

/**
 * pizza super class
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies vegges[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake(){
        System.out.println("Bake for 25 minutirs at 350 " );
    }

    void cut(){
        System.out.println("Cutting the pizza into diagonal slices" );
    }

    void box(){
            System.out.println("Place pizza in offical PizzaStore box" );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", vegges=" + Arrays.toString(vegges) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clams=" + clams +
                '}';
    }
}
