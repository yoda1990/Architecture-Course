package org.hmily.course.designpattern.factory.factorymethod;

public class PizzaTestDriver {
    public static void main(String[] args) {
        PizzaStore ny = new NyStylePizzaStore();
        PizzaStore chicago = new ChicagoStylePizzaStore();

        Pizza pizza = ny.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());

        pizza = chicago.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());

    }

}
