package org.hmily.course.designpattern.factory.factorymethod;

public class ChicagoStylePizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }else if (type.equals("veggie")){
            return new ChicagoStyleVeggiePizza();
        }else if (type.equals("clam")){
            return new ChicagoStyleClamPizza();
        }else if (type.equals("pepperoni")){
            return new ChicagoStylePepperoniPizza();
        }
        return null;
    }
}
