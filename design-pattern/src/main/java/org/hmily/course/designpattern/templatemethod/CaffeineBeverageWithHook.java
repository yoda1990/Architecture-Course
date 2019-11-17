package org.hmily.course.designpattern.templatemethod;

public abstract class CaffeineBeverageWithHook {

    void prepareRecipe(){
        boilWater();
        brew();
        pourIncup();
        if (customerWantsCondiments()){
            addCondiments();
        }
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void brew();

    public void pourIncup() {
        System.out.println("Pouring into cup");
    }

    public boolean customerWantsCondiments() {
        return true;
    }

    abstract void addCondiments();





}
