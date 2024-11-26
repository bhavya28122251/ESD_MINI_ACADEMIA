package org.esdpracticals.academicerp.mapper;

import org.esdpracticals.academicerp.dto.EmployeeRequest;
import org.esdpracticals.academicerp.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {
        return Employee.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .title(request.title())
                .department(request.department())
                .password(request.password())
                .build();
    }

}