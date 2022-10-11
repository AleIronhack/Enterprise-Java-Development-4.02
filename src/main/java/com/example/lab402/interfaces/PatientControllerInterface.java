package com.example.lab402.interfaces;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientControllerInterface {

    List<Patient> findAllPatients();
    Patient findPatientById(Long id);
    List<Patient> findPatientsByDob(LocalDate start, LocalDate end);
    List<Patient> findPatientsByDoctorDepartment(String department);
    List<Patient> findPatientsByDoctorStatus();
}
