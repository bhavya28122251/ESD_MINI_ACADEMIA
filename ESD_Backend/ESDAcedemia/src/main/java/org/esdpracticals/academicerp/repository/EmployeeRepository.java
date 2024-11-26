package org.esdpracticals.academicerp.repository;

import org.esdpracticals.academicerp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    Optional<Employee> findByEmployees(Employee employee);

}