package com.ManagementSystem.ManagementSystem.DTO;

import com.ManagementSystem.ManagementSystem.Entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String phoneNumber;
    private double salary;

    public static EmployeeResponseDTO fromEntity(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setSalary(employee.getSalary());

        return dto;
    }
}