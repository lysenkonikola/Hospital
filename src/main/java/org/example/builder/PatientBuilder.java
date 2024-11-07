package org.example.builder;

import org.example.models.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PatientBuilder {
    private String lastName;
    private String firstName;
    private String idDocument;
    private LocalDate birthDate;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]+$");
    private static final Pattern DOCUMENT_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1900, 1, 1);

    public PatientBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientBuilder idDocument(String idDocument) {
        this.idDocument = idDocument;
        return this;
    }

    public PatientBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Patient build() {
        List<String> validationErrors = validateFields();
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid field values:\n" + String.join("\n", validationErrors));
        }
        return new Patient(lastName, firstName, idDocument, birthDate);
    }

    private List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (lastName == null || !NAME_PATTERN.matcher(lastName).matches()) {
            errors.add("lastName: '" + lastName + "' - must contain only letters and not be empty.");
        }

        if (firstName == null || !NAME_PATTERN.matcher(firstName).matches()) {
            errors.add("firstName: '" + firstName + "' - must contain only letters and not be empty.");
        }

        if (idDocument == null || !DOCUMENT_PATTERN.matcher(idDocument).matches()) {
            errors.add("idDocument: '" + idDocument + "' - must contain only letters and numbers.");
        }

        if (birthDate == null || birthDate.isAfter(LocalDate.now()) || birthDate.isBefore(MIN_BIRTH_DATE)) {
            errors.add("birthDate: '" + birthDate + "' - must be between " + MIN_BIRTH_DATE + " and today.");
        }

        return errors;
    }
}
