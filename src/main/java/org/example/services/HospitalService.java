package org.example.services;

import org.example.models.Appointment;
import org.example.models.Doctor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalService {
    /**
     * Finds all appointments for a given doctor.
     *
     * @param appointments List of all appointments.
     * @param doctor The doctor whose appointments we want to find.
     * @return List of appointments with the specified doctor.
     */
    public List<Appointment> findAppointmentsByDoctor(List<Appointment> appointments, Doctor doctor) {
        return appointments.stream()
                .filter(appointment -> appointment.getDoctor().equals(doctor))
                .collect(Collectors.toList());
    }

    /**
     * Sorts a list of doctors by specialization and then by last name.
     *
     * @param doctors List of doctors.
     * @return Sorted list of doctors by specialization and last name.
     */
    public List<Doctor> sortDoctorsBySpecializationAndName(List<Doctor> doctors) {
        return doctors.stream()
                .sorted(Comparator.comparing(Doctor::getSpecialization)
                        .thenComparing(Doctor::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * Finds all confirmed appointments within a given date range.
     *
     * @param appointments List of all appointments.
     * @param startDate Start of the date range.
     * @param endDate End of the date range.
     * @return List of confirmed appointments within the specified date range.
     */
    public List<Appointment> findConfirmedAppointments(List<Appointment> appointments, LocalDate startDate, LocalDate endDate) {
        return appointments.stream()
                .filter(appointment -> appointment.isConfirmed())
                .filter(appointment -> !appointment.getAppointmentDate().isBefore(startDate) &&
                        !appointment.getAppointmentDate().isAfter(endDate))
                .collect(Collectors.toList());
    }
}
