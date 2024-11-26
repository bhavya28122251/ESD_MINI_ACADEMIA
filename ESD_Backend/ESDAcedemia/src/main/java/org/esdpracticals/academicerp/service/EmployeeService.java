package org.esdpracticals.academicerp.service;

import org.esdpracticals.academicerp.dto.EmployeeRequest;
import org.esdpracticals.academicerp.entity.Employee;
import org.esdpracticals.academicerp.helper.EncryptionService;
import org.esdpracticals.academicerp.mapper.EmployeeMapper;
import org.esdpracticals.academicerp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EncryptionService encryptionService;

    public Employee addEmployee(EmployeeRequest request) {

        Employee employees = employeeMapper.toEntity(request);
        employees.setPassword(encryptionService.encode(request.password()));
        employeeRepository.save(employees);

        return employees;
    }

}