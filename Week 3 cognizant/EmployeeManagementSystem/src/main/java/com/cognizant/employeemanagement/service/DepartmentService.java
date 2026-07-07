package com.cognizant.employeemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.employeemanagement.dto.DepartmentDTO;
import com.cognizant.employeemanagement.entity.Department;
import com.cognizant.employeemanagement.exception.ResourceNotFoundException;
import com.cognizant.employeemanagement.mapper.DepartmentMapper;
import com.cognizant.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper) {

        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDTO)
                .toList();
    }

    public DepartmentDTO getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id: " + id
                        )
                );

        return departmentMapper.toDTO(department);
    }

    public DepartmentDTO createDepartment(
            DepartmentDTO departmentDTO) {

        Department department =
                departmentMapper.toEntity(departmentDTO);

        Department savedDepartment =
                departmentRepository.save(department);

        return departmentMapper.toDTO(savedDepartment);
    }

    public DepartmentDTO updateDepartment(
            Long id,
            DepartmentDTO departmentDTO) {

        Department existingDepartment =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department not found with id: " + id
                                )
                        );

        existingDepartment.setName(departmentDTO.getName());

        Department updatedDepartment =
                departmentRepository.save(existingDepartment);

        return departmentMapper.toDTO(updatedDepartment);
    }

    public void deleteDepartment(Long id) {

        Department department =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department not found with id: " + id
                                )
                        );

        departmentRepository.delete(department);
    }
}