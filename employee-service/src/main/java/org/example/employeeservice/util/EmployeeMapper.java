package org.example.employeeservice.util;

import org.example.employeeservice.dto.EmployeeDTO;
import org.example.employeeservice.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
  EmployeeDTO entityToDto(Employee e);
}
