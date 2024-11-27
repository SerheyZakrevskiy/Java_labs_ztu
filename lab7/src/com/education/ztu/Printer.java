package com.education.ztu;

public class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String data = sharedData.read();
            if ("exit".equalsIgnoreCase(data)) {
                System.out.println("Printer завершив роботу.");
                break;
            }
            System.out.println("Виведено: " + data);
        }
    }
}
