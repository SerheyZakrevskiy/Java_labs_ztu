package com.education.ztu;

public class MainShareData {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread readerThread = new Thread(new Reader(sharedData), "Reader");
        Thread printerThread = new Thread(new Printer(sharedData), "Printer");

        readerThread.start();
        printerThread.start();

        try {
            readerThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано!");
        }

        System.out.println("Програма завершила роботу.");
    }
}
