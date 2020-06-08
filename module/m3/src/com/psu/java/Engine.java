package com.psu.java;

//This is the definition of the engine of a CAR
public class Engine {
    private Double volume; //engine volume e.g. 1.8 , 2.0
    private Integer horsepower; //horsepower of engine e.g. 700, 180
    private Boolean isStarted;

    public Engine() {
        isStarted = false;
    }

    public Engine(Double volume, Integer horsepower) {
        this.volume = volume;
        this.horsepower = horsepower;
        this.isStarted = false;
    }

    public void start() {
        if (isStarted) {
            System.out.println("..Engine already started.. error");
            return;
        }
        isStarted = true;
        System.out.println("...Engine starting...\n");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...started. You may drive.");
    }

    public void stop() {
        if (!isStarted) {
            System.out.println("..Engine already stopped.. error");
            return;
        }
        isStarted = false;
        System.out.println("...Engine stopping...\n");
        System.out.println("...stopped.");
    }

    public Double getVolume() {
        return volume;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public String getInfo() {
        return String.format("Volume: %.2f,\nPower: %d", this.volume, this.horsepower);
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
}
