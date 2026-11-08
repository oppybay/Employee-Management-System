
package com.ManagementSystem.ManagementSystem.controller;

import com.ManagementSystem.ManagementSystem.DTO.EmployeeResponseDTO;
import com.ManagementSystem.ManagementSystem.Entity.Employee;
import com.ManagementSystem.ManagementSystem.Services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.ManagementSystem.ManagementSystem.DTO.EmployeeRequestDTO;
import java.util.List;

@RestController
@RequestMapping("/api/ManagementSystem")
@AllArgsConstructor

public class ManagementSystemController {

    private EmployeeService employeeService;

    // CREATE EMPLOYEE

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {

        Employee employee = employeeDTO.toEntity();

        Employee savedEmployee = employeeService.createEmployee(employee);

        EmployeeResponseDTO response =
                EmployeeResponseDTO.fromEntity(savedEmployee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // Get All Employees
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeResponseDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(employees);
    }

    // Get Employee By ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(
            @PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id);

        EmployeeResponseDTO response =
                EmployeeResponseDTO.fromEntity(employee);

        return ResponseEntity.ok(response);
    }

    // Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {

        Employee employee = employeeDTO.toEntity();

        Employee updatedEmployee =
                employeeService.updateEmployee(id, employee);

        EmployeeResponseDTO response =
                EmployeeResponseDTO.fromEntity(updatedEmployee);

        return ResponseEntity.ok(response);
    }


    // Delete Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee deleted successfully");
    }

}
