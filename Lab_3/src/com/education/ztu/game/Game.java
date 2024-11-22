package com.education.ztu.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Schoolar schoolar3 = new Schoolar("Olga", 12);
        Schoolar schoolar4 = new Schoolar("Ivan", 14);

        List<Participant> participants = new ArrayList<>();
        participants.add(schoolar1);
        participants.add(schoolar2);
        participants.add(schoolar3);
        participants.add(schoolar4);

        System.out.println("Original list:");
        participants.forEach(System.out::println);

        Collections.sort(participants);
        System.out.println("\nSorted by name:");
        participants.forEach(System.out::println);

        participants.sort(new AgeComparator());
        System.out.println("\nSorted by age:");
        participants.forEach(System.out::println);

        participants.sort(NameThenAgeComparator.getComparator());
        System.out.println("\nSorted by name, then by age:");
        participants.forEach(System.out::println);
    }
}
