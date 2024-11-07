package org.example.models;

public class Doctor {
    private final String lastName;
    private final String firstName;
    private final String specialization;

    public Doctor(String lastName, String firstName, String specialization) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.specialization = specialization;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
