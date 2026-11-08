
package com.ManagementSystem.ManagementSystem.Services;

import com.ManagementSystem.ManagementSystem.Entity.Employee;
import com.ManagementSystem.ManagementSystem.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.ManagementSystem.ManagementSystem.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    // Create and save an employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id
                        ));
    }


    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id));

        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setMiddleName(updatedEmployee.getMiddleName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id));

        employeeRepository.delete(employee);
    }

}
