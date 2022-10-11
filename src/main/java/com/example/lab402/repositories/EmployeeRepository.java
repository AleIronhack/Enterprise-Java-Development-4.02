package com.example.lab402.repositories;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);
}
