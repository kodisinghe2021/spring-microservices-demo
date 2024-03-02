package org.example.employeeservice.repository;

import org.example.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

  boolean existsByEmailEquals(String email);

  Employee findByEmailEquals(String email);
}
