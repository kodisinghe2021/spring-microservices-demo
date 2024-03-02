package org.example.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.example.departmentservice.dto.DepartmentDTO;
import org.example.departmentservice.entity.Department;
import org.example.departmentservice.repository.DepartmentRepo;
import org.example.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

  private DepartmentRepo departmentRepo;
  @Override
  public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

    Department department = new Department(
            1l,
            departmentDTO.getDepartmentName(),
            departmentDTO.getDepartmentDescription(),
            departmentDTO.getDepartmentCode()
    );

    if(!departmentRepo.existsByDepartmentNameEquals(department.getDepartmentName())){
   Department d = departmentRepo.save(department);
  return new DepartmentDTO(
           d.getId(),
           d.getDepartmentName(),
           d.getDepartmentDescription(),
           d.getDepartmentCode()
   );
    }else {
      return null;
    }
  }

  @Override
  public DepartmentDTO getDepartmentByCode(String departmentCode) {
    if(departmentRepo.existsByDepartmentCode(departmentCode)){
  Department d =    departmentRepo.findByDepartmentCode(departmentCode);
  return new DepartmentDTO(
          d.getId(),
          d.getDepartmentName(),
          d.getDepartmentDescription(),
          d.getDepartmentCode()
  );
    }else {
     return null;
    }
  }
}
