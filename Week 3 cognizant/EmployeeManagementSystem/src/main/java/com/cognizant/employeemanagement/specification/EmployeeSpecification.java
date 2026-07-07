package com.cognizant.employeemanagement.specification;

import org.springframework.data.jpa.domain.Specification;

import com.cognizant.employeemanagement.entity.Employee;

public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<Employee> nameContains(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + keyword.toLowerCase() + "%"
                );
    }

    public static Specification<Employee> belongsToDepartment(
            String departmentName) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("department").get("name"),
                        departmentName
                );
    }

    private EmployeeSpecification() {
    }
}