package org.hmily.course.designpattern.observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;

    private Subject subject;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("temperature : " + temperature + ",humidity : " + humidity +",pressure : "+ pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
         this.temperature = temp;
         this.humidity = humidity;
         this.pressure = pressure;
         display();
    }
}
