package com.cognizant.employeemanagement.mapper;

import org.mapstruct.Mapper;

import com.cognizant.employeemanagement.dto.DepartmentDTO;
import com.cognizant.employeemanagement.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO toDTO(Department department);

    Department toEntity(DepartmentDTO departmentDTO);
}