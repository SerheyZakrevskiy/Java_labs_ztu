package com.education.ztu;

import com.education.ztu.game.*;

public class Main {

    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);

        System.out.println("Participants:");
        System.out.println(schoolar1);
        System.out.println(schoolar2);

        System.out.println("\nEquality check:");
        System.out.println("schoolar1.equals(schoolar2): " + schoolar1.equals(schoolar2));

        System.out.println("\nHash codes:");
        System.out.println("schoolar1.hashCode(): " + schoolar1.hashCode());
        System.out.println("schoolar2.hashCode(): " + schoolar2.hashCode());

        try {
            Schoolar clonedSchoolar = (Schoolar) schoolar1.clone();
            System.out.println("\nCloned participant:");
            System.out.println(clonedSchoolar);

            System.out.println("\nEquality check with clone:");
            System.out.println("schoolar1.equals(clonedSchoolar): " + schoolar1.equals(clonedSchoolar));

        } catch (Exception e) {
            System.out.println("Error during cloning: " + e.getMessage());
        }

        Team<Schoolar> team1 = new Team<>("Dragon");
        team1.addNewParticipant(schoolar1);
        team1.addNewParticipant(schoolar2);

        System.out.println("\nOriginal team:");
        System.out.println(team1);

        Team<Schoolar> clonedTeam = new Team<>(team1);

        System.out.println("\nCloned team:");
        System.out.println(clonedTeam);

        System.out.println("\nDeep cloning check:");
        System.out.println("Are participant lists the same? " + (team1.getParticipants() == clonedTeam.getParticipants()));
        System.out.println("Are participants equal? " + team1.getParticipants().equals(clonedTeam.getParticipants()));
    }
}
