package com.cognizant.employeemanagement.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.employeemanagement.entity.Department;
import com.cognizant.employeemanagement.entity.Employee;
import com.cognizant.employeemanagement.repository.DepartmentRepository;
import com.cognizant.employeemanagement.repository.EmployeeRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataInitializer(
            DepartmentRepository departmentRepository,
            EmployeeRepository employeeRepository) {

        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {

        Department itDepartment = new Department("IT");
        Department hrDepartment = new Department("HR");

        departmentRepository.save(itDepartment);
        departmentRepository.save(hrDepartment);

        Employee employee1 = new Employee(
                "Ravi",
                "ravi@gmail.com",
                itDepartment
        );

        Employee employee2 = new Employee(
                "Priya",
                "priya@gmail.com",
                hrDepartment
        );

        Employee employee3 = new Employee(
                "Arjun",
                "arjun@gmail.com",
                itDepartment
        );

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        System.out.println("Sample data inserted successfully!");
    }
}