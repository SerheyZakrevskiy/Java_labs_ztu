package com.education.ztu;

public class Student extends Person {
    private String university;

    public Student(String firstName, String lastName, int age, Location location, Gender gender, String university) {
        super(firstName, lastName, age, location, gender);
        this.university = university;
    }

    @Override
    public String getOccupation() {
        return "Student at " + university;
    }

    public void study() {
        System.out.println(getFirstName() + " is studying at " + university + ".");
    }
}
