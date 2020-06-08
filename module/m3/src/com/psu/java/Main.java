package com.psu.java;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {
    private static final AtomicLong id = new AtomicLong(0);
    private static final AtomicInteger randomizer = new AtomicInteger(123);
    private static final Set<String> STRINGS = Set.of("exit", "e");

    public static void main(String[] args) {
        Map<Long, Car> carGarage = new HashMap<>();
        //inputNewCarManualAndAddToGarage(carGarage);
        generateRandomCarsAndAddToGarage(carGarage, 20); //generate and add 20 random cars to our garage


        //pick one element by its own unique key
        System.out.println(carGarage.get(1L).getInfo());
        //get all elements
        System.out.println("Garage size: " + carGarage.values().size()); //size = 20
        //empty test
        System.out.println("is garage empty: " + carGarage.isEmpty()); //false, bcs we have 20 cars in map
        //add new elem to our garage
        carGarage.put(id.incrementAndGet(), randomCar());
        //new size is 21
        System.out.println("new garage size: " + carGarage.size());
        //start all car engines
        //it is example how to use lambda-expressions in functional interfaces
        carGarage.forEach((aLong, car) -> car.startEngine());
        //this is how to use func interface without lambda
        carGarage.forEach(new BiConsumer<>() {
            //to user func interface without lambda you need to implement
            //this interface as anonymous class
            @Override
            public void accept(Long aLong, Car car) {
                car.stopEngine(); //cars will stop one by one
            }
        });
        //filter test
        //to filter the collection you need to stream this, and implement func interface @Predicate
        //pick only BMW hatchbacks
        List<Car> hatchbacksOnly = carGarage.values()
                .stream()
                .filter(car -> car.getBodyType().equals(BodyType.HATCHBACK) && car.getMark().equals(Mark.BMW))
                .collect(Collectors.toList());
        printCollection(hatchbacksOnly);

        Map<Long, Car> someonesGarage = new HashMap<>();
        generateRandomCarsAndAddToGarage(someonesGarage, 5);

        //to put another map to map user putAll(anotherMap)
        carGarage.putAll(someonesGarage);
        System.out.println(carGarage.size());//size 26
        //to clear collection fully use .clear() method
        carGarage.clear();
    }


    private static void inputNewCarManualAndAddToGarage(Map<Long, Car> garage) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        System.out.println("Ручной ввод записей об автомобилях (е/exit для выхода, любая клавиша для продолжения):");
        while (true) {
            String answer = scanner.nextLine();
            if (STRINGS.contains(answer)) {
                return;
            }
            Engine engine = new Engine();
            System.out.println("Объем двигателя: ");
            engine.setVolume(scanner.nextDouble());
            System.out.println("Кол-во л.с.: ");
            engine.setHorsepower(scanner.nextInt());
            System.out.println("Тип кузова: SEDAN/HATCHBACK/JEEP ");
            car.setBodyType(BodyType.valueOf(scanner.nextLine()));
            System.out.println("Марка: BMW/LADA/BENTLEY/PORSCHE");
            car.setMark(Mark.valueOf(scanner.nextLine()));
            car.setEngine(engine);
            System.out.println("Цена: ");
            car.setPrice(scanner.nextDouble());
            garage.put(id.incrementAndGet(), car);
        }
    }

    private static void generateRandomCarsAndAddToGarage(Map<Long, Car> garage, int count) {
        for (int i = 0; i < count; i++) {
            garage.put(id.incrementAndGet(), randomCar());
        }
    }

    private static Car randomCar() {
        Car carToGenerate = new Car();
        Engine engineToGenerate = new Engine();
        Random random = new Random(randomizer.get());
        randomizer.set(random.nextInt());
        random.nextInt(2);
        engineToGenerate.setHorsepower(random.nextInt(950));
        engineToGenerate.setVolume(random.nextDouble() * 5);
        carToGenerate.setEngine(engineToGenerate);
        carToGenerate.setPrice(random.nextDouble() * 75000);
        carToGenerate.setMark(Mark.values()[random.nextInt(3)]);
        carToGenerate.setBodyType(BodyType.values()[random.nextInt(2)]);
        return carToGenerate;
    }

    private static <T> void printCollection(Collection<T> c) {
        c.forEach(t -> System.out.println(t.toString()));
        System.out.println(String.format("collection size: %d", c.size()));
    }
}
