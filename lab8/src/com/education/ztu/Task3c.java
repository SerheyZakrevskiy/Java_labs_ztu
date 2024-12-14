package com.education.ztu;

import java.util.function.Supplier;

public class Task3c {
    public static void main(String[] args) {
        Supplier<String> uppercaseSupplier = () -> "Лямбда вирази - це круто!".toUpperCase();

        System.out.println(uppercaseSupplier.get());
    }
}
