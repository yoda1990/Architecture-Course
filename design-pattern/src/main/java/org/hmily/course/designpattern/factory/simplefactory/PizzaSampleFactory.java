package org.hmily.course.designpattern.factory.simplefactory;

public class PizzaSampleFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("cheese")){
            return new CheesePizza();
        }else if(type.equals("pepperoni")){
            return new PeppperoniPizza();
        }else if (type.equals("clam")){
            return new ClamPizza();
        }else if (type.equals("veggie")){
            return new ViggiePizza();
        }
        return pizza;
    }

}
