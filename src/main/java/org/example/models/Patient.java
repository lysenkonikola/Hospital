package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Patient implements Comparable<Patient> {
    private final String lastName;
    private final String firstName;
    private final String idDocument;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate birthDate;

    public Patient( @JsonProperty("lastName") String lastName,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("idDocument") String idDocument,
                    @JsonProperty("birthDate") LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDocument = idDocument;
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", idDocument='" + idDocument + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Patient other) {
        int lastNameComparison = lastName.compareTo(other.lastName);
        return lastNameComparison != 0 ? lastNameComparison : firstName.compareTo(other.firstName);    }
}
