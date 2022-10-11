package com.example.lab402.interfaces;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Employee;

import java.util.List;

public interface EmployeeControllerInterface {
    List<Employee> getAllEmployees();
    Employee findEmployeeById(Long id);
    List<Employee> findEmployeeByStatus(Status status);
    List<Employee> findEmployeeByDepartment(String department);
}
