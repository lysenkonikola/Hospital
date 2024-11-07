package org.example.dao;


import org.example.models.Patient;
import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient);
    Patient getPatientByIdDocument(String idDocument);
    List<Patient> getAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(String idDocument);
}
