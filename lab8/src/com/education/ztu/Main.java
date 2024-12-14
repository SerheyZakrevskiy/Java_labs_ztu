package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Це реалізація через лямбда-вираз!");

        printable.print();
    }
}
