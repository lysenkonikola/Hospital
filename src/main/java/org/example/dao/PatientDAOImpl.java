package org.example.dao;

import org.example.dao.PatientDAO;
import org.example.models.Patient;
import org.example.config.DatabaseConfig;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (last_name, first_name, id_document, birth_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getIdDocument());
            ps.setString(4, patient.getBirthDate().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatientByIdDocument(String idDocument) {
        String query = "SELECT * FROM patients WHERE id_document = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, idDocument);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("id_document"),
                        LocalDate.parse(rs.getString("birth_date"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                patients.add(new Patient(
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("id_document"),
                        LocalDate.parse(rs.getString("birth_date"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public void updatePatient(Patient patient) {
        String query = "UPDATE patients SET last_name = ?, first_name = ?, birth_date = ? WHERE id_document = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getBirthDate().toString());
            ps.setString(4, patient.getIdDocument());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(String idDocument) {
        String query = "DELETE FROM patients WHERE id_document = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, idDocument);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}