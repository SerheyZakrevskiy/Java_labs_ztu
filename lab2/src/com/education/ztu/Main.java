package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Всі можливі значення Location:");
        for (Location location : Location.values()) {
            System.out.println(location);
        }
    }
}
