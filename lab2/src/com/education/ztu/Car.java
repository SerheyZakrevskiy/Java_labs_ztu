package com.education.ztu;

public class Car {
    private String model;
    private Engine engine;

    public Car(String model) {
        this.model = model;
        this.engine = new Engine();
    }

    public void startCar() {
        engine.startEngine();
    }

    public void stopCar() {
        engine.stopEngine();
    }

    private class Engine {
        private boolean isRunning = false;

        public void startEngine() {
            isRunning = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            isRunning = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return isRunning;
        }
    }
}
