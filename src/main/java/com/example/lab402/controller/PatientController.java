package com.example.lab402.controller;

import com.example.lab402.enums.Status;
import com.example.lab402.interfaces.PatientControllerInterface;
import com.example.lab402.models.Patient;
import com.example.lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController implements PatientControllerInterface {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient findPatientById(@PathVariable Long id) {
        if(patientRepository.findById(id).isPresent()){

            return patientRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/patients-dob")
    public List<Patient> findPatientsByDob(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/patients-department/{department}")
    public List<Patient> findPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patients-status")
    public List<Patient> findPatientsByDoctorStatus() {
        return patientRepository.findByAdmittedByStatus(Status.OFF);
    }


}
