package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants;

    public Team(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public Team(Team<T> other) {
        this.name = other.name;
        this.participants = new ArrayList<>();
        for (T participant : other.participants) {
            this.participants.add((T) participant.clone());
        }
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public String getName() {
        return name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Team{name='" + name + "', participants=" + participants + "}";
    }
}
