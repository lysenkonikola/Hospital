package org.example;

import org.example.builder.AppointmentBuilder;
import org.example.builder.PatientBuilder;
import org.example.dao.PatientDAO;
import org.example.dao.PatientDAOImpl;
import org.example.models.Appointment;
import org.example.models.Doctor;
import org.example.models.Patient;
import org.example.serializer.JsonSerializer;
import org.example.serializer.XmlSerializer;
import org.example.serializer.YamlSerializer;
import org.example.services.HospitalService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Patient patient1 = new Patient("Doe", "John", "ID12345", LocalDate.of(1985, 4, 12));
        Patient patient2 = new Patient("Smith", "Jane", "ID67890", LocalDate.of(1990, 8, 22));

        Doctor doctor1 = new Doctor("Brown", "Emily", "Cardiology");
        Doctor doctor2 = new Doctor("White", "Chris", "Neurology");

        Appointment appointment1 = new Appointment(patient1, doctor1, LocalDate.of(2024, 10, 20), LocalTime.of(10, 0), true);
        Appointment appointment2 = new Appointment(patient2, doctor1, LocalDate.of(2024, 10, 22), LocalTime.of(15, 30), false);
        Appointment appointment3 = new Appointment(patient1, doctor2, LocalDate.of(2024, 10, 25), LocalTime.of(14, 0), true);

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2, appointment3);
        List<Doctor> doctors = Arrays.asList(doctor1, doctor2);

        HospitalService hospitalService = new HospitalService();

        // 1. Find appointments for a specific doctor
        List<Appointment> doctor1Appointments = hospitalService.findAppointmentsByDoctor(appointments, doctor1);
        System.out.println("Appointments for Dr. Brown: " + doctor1Appointments);

        // 2. Sort doctors by specialization and last name
        List<Doctor> sortedDoctors = hospitalService.sortDoctorsBySpecializationAndName(doctors);
        System.out.println("Sorted Doctors: " + sortedDoctors);

        // 3. Find confirmed appointments within a date range
        List<Appointment> confirmedAppointments = hospitalService.findConfirmedAppointments(appointments, LocalDate.of(2024, 10, 18), LocalDate.of(2024, 10, 23));
        System.out.println("Confirmed Appointments in date range: " + confirmedAppointments);

        System.out.println("------------------Lab 3 --------------");
        Patient patientForSerializer = new Patient("Doe", "John", "ID12345", LocalDate.of(1985, 4, 12));

        JsonSerializer<Patient> jsonSerializer = new JsonSerializer<>(Patient.class);
        try {
            jsonSerializer.serialize(patientForSerializer, new File("patient.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Patient deserializedJsonPatient = (Patient) jsonSerializer.deserialize(new File("patient.json"));
        System.out.println("Deserialized from JSON: " + deserializedJsonPatient);

        XmlSerializer<Patient> xmlSerializer = new XmlSerializer<>(Patient.class);

        try {
            xmlSerializer.serialize(patientForSerializer,new File("patient.xml"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        Patient deserializedXmlPatient = (Patient) xmlSerializer.deserialize(new File("patient.xml"));
        System.out.println("Deserialized from XML: " + deserializedXmlPatient);

        YamlSerializer<Patient> yamlSerializer = new YamlSerializer<>(Patient.class);

        try {
            yamlSerializer.serialize(patientForSerializer,new File("patient.yaml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Patient deserializedYamlPatient = (Patient)yamlSerializer.deserialize(new File("patient.yaml"));
        System.out.println("Deserialized from YAML: " + deserializedYamlPatient);

        System.out.println("------------------Lab 4 --------------");

        try {
            Patient patient = new PatientBuilder()
                    .lastName("Doe")
                    .firstName("John")
                    .idDocument("ID12345")
                    .birthDate(LocalDate.of(1985, 4, 12))
                    .build();

            Doctor doctor = new Doctor("Smith", "Emily", "Cardiology");

            Appointment appointment = new AppointmentBuilder()
                    .patient(patient)
                    .doctor(doctor)
                    .appointmentDate(LocalDate.of(2024, 10, 20))
                    .appointmentTime(LocalTime.of(14, 30))
                    .isConfirmed(true)
                    .build();

            System.out.println("Appointment created successfully: " + appointment);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed with errors:");
            System.out.println(e.getMessage());
        }

        // Створення екземпляра DAO для роботи з базою даних
        PatientDAO patientDAO = new PatientDAOImpl();


        System.out.println("Додаємо пацієнтів...");
        patientDAO.addPatient(patient1);
        patientDAO.addPatient(patient2);

        // 2. Отримання всіх пацієнтів
        System.out.println("Отримуємо всіх пацієнтів:");
        List<Patient> patients = patientDAO.getAllPatients();
        for (Patient p : patients) {
            System.out.println(p);
        }

        // 3. Отримання пацієнта за документом ID
        System.out.println("Отримуємо пацієнта з ID 'ID12345':");
        Patient retrievedPatient = patientDAO.getPatientByIdDocument("ID12345");
        System.out.println(retrievedPatient);

        // 4. Оновлення інформації про пацієнта
        System.out.println("Оновлюємо інформацію про пацієнта з ID 'ID12345'...");
        Patient updatedPatient = new Patient("Shevchenko", "Taras", "ID12345", LocalDate.of(1981, 2, 20));
        patientDAO.updatePatient(updatedPatient);

        // Перевірка оновлення
        System.out.println("Отримуємо оновленого пацієнта з ID 'ID12345':");
        Patient updatedRetrievedPatient = patientDAO.getPatientByIdDocument("ID12345");
        System.out.println(updatedRetrievedPatient);

        // 5. Видалення пацієнта
        System.out.println("Видаляємо пацієнта з ID 'ID54321'...");
     //   patientDAO.deletePatient("ID54321");

        // Перевірка видалення
        System.out.println("Отримуємо всіх пацієнтів після видалення:");
        patients = patientDAO.getAllPatients();
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}