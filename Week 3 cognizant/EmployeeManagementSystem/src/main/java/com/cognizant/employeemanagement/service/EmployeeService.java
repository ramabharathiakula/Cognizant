package com.cognizant.employeemanagement.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagement.dto.EmployeeDTO;
import com.cognizant.employeemanagement.entity.Employee;
import com.cognizant.employeemanagement.exception.ResourceNotFoundException;
import com.cognizant.employeemanagement.mapper.EmployeeMapper;
import com.cognizant.employeemanagement.repository.EmployeeRepository;
import com.cognizant.employeemanagement.specification.EmployeeSpecification;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            EmployeeMapper employeeMapper) {

        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }

    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        return employeeMapper.toDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = employeeMapper.toEntity(employeeDTO);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(
            Long id,
            EmployeeDTO employeeDTO) {

        Employee existingEmployee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id: " + id
                                )
                        );

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setEmail(employeeDTO.getEmail());

        Employee updatedEmployee =
                employeeRepository.save(existingEmployee);

        return employeeMapper.toDTO(updatedEmployee);
    }

    public void deleteEmployee(Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee not found with id: " + id
                                )
                        );

        employeeRepository.delete(employee);
    }

    public List<EmployeeDTO> searchEmployees(
            String name,
            String email,
            String departmentName) {

        Specification<Employee> specification =
                Specification.where(null);

        if (name != null && !name.isBlank()) {
            specification = specification.and(
                    EmployeeSpecification.nameContains(name)
            );
        }

        if (email != null && !email.isBlank()) {
            specification = specification.and(
                    EmployeeSpecification.hasEmail(email)
            );
        }

        if (departmentName != null
                && !departmentName.isBlank()) {

            specification = specification.and(
                    EmployeeSpecification.belongsToDepartment(
                            departmentName
                    )
            );
        }

        return employeeRepository.findAll(specification)
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }
}