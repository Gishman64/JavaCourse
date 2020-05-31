package com.psu.java;

public class Main {

    public static void main(String[] args) {
        Engine bmwEngine = new Engine(2.4,700);
        Car bmwM3 = new Car(Mark.BMW,bmwEngine,BodyType.SEDAN,78000D);
        bmwM3.startEngine();//start engine here. You may add another iterations with car, or engine
        bmwM3.stopEngine(); //stop engine here.
        System.out.println(bmwM3.getInfo());
    }
}
