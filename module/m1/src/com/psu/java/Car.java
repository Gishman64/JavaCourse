package com.psu.java;

//This is the definition of class CAR
public class Car {
    private Mark mark;
    private Engine engine;
    private BodyType bodyType;
    private Double price;

    //Class constructor with params
    public Car(Mark mark, Engine engine, BodyType bodyType, Double price) {
        this.mark = mark;
        this.engine = engine;
        this.bodyType = bodyType;
        this.price = price;
    }

    public void startEngine() {
        this.engine.start();
    }

    public void stopEngine() {
        this.engine.stop();
    }

    public String getInfo() {
        return String.format("Mark: %s %s,\n%s,\n%s,\n%.2f\n",
                this.mark.name(), this.mark.getCountry(),
                this.engine.toString(),
                this.bodyType.name(),
                this.price);
    }
}
