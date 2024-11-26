package org.esdpracticals.academicerp.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.esdpracticals.academicerp.dto.EmployeeRequest;
import org.esdpracticals.academicerp.entity.Employee;
import org.esdpracticals.academicerp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.addEmployee(request));
    }

}