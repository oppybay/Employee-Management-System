# Employee Management System

## Project Description

The Employee Management System is a RESTful API
built with Java and Spring Boot. It allows users
to manage employee records and store employee
information in a MySQL database.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Bean Validation

## Features

- Create a new employee
- Retrieve all employees
- Retrieve an employee by ID
- Update employee information
- Delete an employee
- Validate employee input
- Handle exceptions


## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/ManagementSystem/employees` | Create an employee |
| GET | `/api/ManagementSystem/employees` | Get all employees |
| GET | `/api/ManagementSystem/employees/{id}` | Get employee by ID |
| PUT | `/api/ManagementSystem/employees/{id}` | Update employee |
| DELETE | `/api/ManagementSystem/employees/{id}` | Delete employee |



## Database Configuration

1. Install MySQL.
2. Create a database named `employee_db`.
3. Open `src/main/resources/application.properties`.
4. Configure your own MySQL username and password.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true