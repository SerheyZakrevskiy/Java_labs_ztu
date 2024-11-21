package com.education.ztu;

public abstract class Person implements Human {
    private String firstName;
    private String lastName;
    private int age;
    private Location location;
    private Gender gender;

    public Person(String firstName, String lastName, int age, Location location, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Location getLocation() {
        return location;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public void sayFullName() {
        System.out.println("Full Name: " + firstName + " " + lastName);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }

    public abstract String getOccupation();
}
