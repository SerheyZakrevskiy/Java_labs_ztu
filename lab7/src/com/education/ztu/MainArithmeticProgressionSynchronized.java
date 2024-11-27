package com.education.ztu;

public class MainArithmeticProgressionSynchronized {
    public static void main(String[] args) {
        ArithmeticProgression task = new ArithmeticProgression();

        Thread thread1 = new Thread(task, "Потік-1");
        Thread thread2 = new Thread(task, "Потік-2");
        Thread thread3 = new Thread(task, "Потік-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано!");
        }

        System.out.println("\nГоловний потік завершив роботу.");
    }
}
