package org.example.employeeservice.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResEmployeeWithDep {
  private EmployeeDTO employeeDTO;
  private DepartmentDTO departmentDTO;
}
