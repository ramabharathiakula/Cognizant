package com.cognizant.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagement.entity.Department;

@Repository
public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

    // Find department by exact name
    List<Department> findByName(String name);

    // Find departments whose name contains keyword
    List<Department> findByNameContaining(String keyword);

    // Find departments whose name starts with given text
    List<Department> findByNameStartingWith(String prefix);

    // Find departments whose name ends with given text
    List<Department> findByNameEndingWith(String suffix);
}