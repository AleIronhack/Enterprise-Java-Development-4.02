package com.example.lab402.controller;

import com.example.lab402.enums.Status;
import com.example.lab402.interfaces.EmployeeControllerInterface;
import com.example.lab402.models.Employee;
import com.example.lab402.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    EmployeeRepository employeeRepository;



    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        if(employeeRepository.findById(id).isPresent()){
            return employeeRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/employeestatus/{status}")
    public List<Employee> findEmployeeByStatus(@PathVariable Status status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/employeesdepartment/{department}")
    public List<Employee> findEmployeeByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }
}
