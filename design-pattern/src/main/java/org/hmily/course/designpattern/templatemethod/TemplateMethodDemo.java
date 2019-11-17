package org.hmily.course.designpattern.templatemethod;

public class TemplateMethodDemo {

    public static void main(String[] args) {
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareRecipe();
    }

}
