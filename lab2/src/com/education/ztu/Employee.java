package com.education.ztu;

public class Employee extends Person {
    private String company;
    private Car car;

    public Employee(String firstName, String lastName, int age, Location location, Gender gender, String company, Car car) {
        super(firstName, lastName, age, location, gender);
        this.company = company;
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "Employee at " + company;
    }

    public void work() {
        System.out.println(getFirstName() + " is working at " + company + ".");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
