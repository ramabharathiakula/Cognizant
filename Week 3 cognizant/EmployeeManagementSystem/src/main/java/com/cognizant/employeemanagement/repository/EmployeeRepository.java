package com.cognizant.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long>,
                JpaSpecificationExecutor<Employee> {

    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByEmailContaining(String keyword);
}