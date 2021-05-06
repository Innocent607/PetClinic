package com.example.PetClinic.model;

public class Person extends BaseEntity{

    // instance variables
    private String firstName;
    private String lastName;

    /*
    // class constructor
    public Person(){

    }

    // class constructor with instance variables
    public Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
