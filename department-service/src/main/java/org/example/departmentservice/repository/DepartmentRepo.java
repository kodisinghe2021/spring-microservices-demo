package org.example.departmentservice.repository;

import org.example.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

  boolean existsByDepartmentNameEquals(String departmentName);

  boolean existsByDepartmentCode(String departmentCode);

  Department findByDepartmentCode(String departmentCode);
}
