package com.education.ztu;

public class Teacher extends Person {
    private String subject;
    private Car car;

    public Teacher(String firstName, String lastName, int age, Location location, Gender gender, String subject, Car car) {
        super(firstName, lastName, age, location, gender);
        this.subject = subject;
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "Teacher of " + subject;
    }

    public void teach() {
        System.out.println(getFirstName() + " is teaching " + subject + ".");
    }
}
