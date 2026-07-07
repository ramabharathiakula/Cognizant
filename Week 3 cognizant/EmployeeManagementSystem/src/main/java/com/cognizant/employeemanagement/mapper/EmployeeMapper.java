package com.cognizant.employeemanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cognizant.employeemanagement.dto.EmployeeDTO;
import com.cognizant.employeemanagement.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(
        source = "department.id",
        target = "departmentId"
    )
    @Mapping(
        source = "department.name",
        target = "departmentName"
    )
    EmployeeDTO toDTO(Employee employee);

    @Mapping(
        target = "department",
        ignore = true
    )
    Employee toEntity(EmployeeDTO employeeDTO);
}