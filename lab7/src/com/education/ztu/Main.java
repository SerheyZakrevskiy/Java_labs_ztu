package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        System.out.println("Стан потоку: " + myThread.getState());
        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи потік живий: " + myThread.isAlive());
        System.out.println("Чи є потік демоном: " + myThread.isDaemon());

        myThread.start();
        System.out.println("Стан потоку після start(): " + myThread.getState());

        myThread.setName("ProgrammingThread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріоритет потоку: " + myThread.getPriority());

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Стан потоку після завершення: " + myThread.getState());
        System.out.println("Чи потік живий після завершення: " + myThread.isAlive());

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());

        MyRunnable task = new MyRunnable();

        Thread thread1 = new Thread(task, "Потік-1");
        Thread thread2 = new Thread(task, "Потік-2");
        Thread thread3 = new Thread(task, "Потік-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано!");
        }

        System.out.println("Перериваємо роботу потоків...");
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано під час очікування!");
        }

        System.out.println("Головний потік завершив роботу.");



    }
}
