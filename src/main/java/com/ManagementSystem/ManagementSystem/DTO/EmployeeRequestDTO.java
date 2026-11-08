package com.ManagementSystem.ManagementSystem.DTO;

import com.ManagementSystem.ManagementSystem.Entity.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    private String department;

    @Pattern(
            regexp = "^[0-9]{11}$",
            message = "Phone number must contain exactly 11 digits"
    )
    private String phoneNumber;

    @Positive(message = "Salary must be greater than zero")
    private double salary;



    public Employee toEntity() {
        Employee employee = new Employee();

        employee.setFirstName(this.firstName);
        employee.setLastName(this.lastName);
        employee.setEmail(this.email);
        employee.setDepartment(this.department);
        employee.setPhoneNumber(this.phoneNumber);
        employee.setSalary(this.salary);

        return employee;
    }

}
