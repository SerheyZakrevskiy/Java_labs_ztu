package com.education.ztu;

import java.util.function.Consumer;

public class Task3b {
    public static void main(String[] args) {
        Consumer<String> startPair = s -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endPair = s -> System.out.println("Пара закінчилася о 9:50");

        Consumer<String> pairTimeline = startPair.andThen(endPair);

        pairTimeline.accept("Інформатика");
    }
}
