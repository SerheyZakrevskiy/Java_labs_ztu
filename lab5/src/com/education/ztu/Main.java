package com.education.ztu;

public class Main {
    public static void main(String[] args) {

        System.out.println("Демонстрація роботи з чергою:");
        QueueDemo.execute();

        System.out.println("Демонстрація роботи з динамічним масивом:");
        DynamicArrayDemo.execute();

        System.out.println("Демонстрація роботи з множиною:");
        SetDemo.execute();

        System.out.println("Демонстрація роботи з Map:");
        MapDemo.execute();

        System.out.println("Демонстрація роботи з класом Collections:");
        CollectionsDemo.execute();
    }
}
