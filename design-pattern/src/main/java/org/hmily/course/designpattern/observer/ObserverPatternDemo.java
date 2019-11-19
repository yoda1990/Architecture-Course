package org.hmily.course.designpattern.observer;

public class ObserverPatternDemo {

    public static void main(String[] args) {

         WeatherData weatherData = new WeatherData();
         CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
         weatherData.setMeasurements(14,15,99.0f);
    }

}
