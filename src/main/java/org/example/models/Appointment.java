package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDate appointmentDate;
    private final LocalTime appointmentTime;
    private final boolean isConfirmed;

    public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime, boolean isConfirmed) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.isConfirmed = isConfirmed;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
