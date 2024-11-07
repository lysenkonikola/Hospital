package org.example.builder;

import org.example.models.Appointment;
import org.example.models.Doctor;
import org.example.models.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentBuilder {
    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private boolean isConfirmed;

    public AppointmentBuilder patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public AppointmentBuilder doctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public AppointmentBuilder appointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
        return this;
    }

    public AppointmentBuilder appointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
        return this;
    }

    public AppointmentBuilder isConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
        return this;
    }

    public Appointment build() {
        List<String> validationErrors = validateFields();
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid field values:\n" + String.join("\n", validationErrors));
        }
        return new Appointment(patient, doctor, appointmentDate, appointmentTime, isConfirmed);
    }

    private List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (patient == null) {
            errors.add("patient: must be specified.");
        }

        if (doctor == null) {
            errors.add("doctor: must be specified.");
        }

        if (appointmentDate == null || appointmentDate.isBefore(LocalDate.now())) {
            errors.add("appointmentDate: '" + appointmentDate + "' - must be today or later.");
        }

        if (appointmentTime == null) {
            errors.add("appointmentTime: must be specified.");
        }

        return errors;
    }
}
