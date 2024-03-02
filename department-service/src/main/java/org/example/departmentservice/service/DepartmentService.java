package org.example.departmentservice.service;

import org.example.departmentservice.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
 DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

 DepartmentDTO getDepartmentByCode(String departmentCode);
}
