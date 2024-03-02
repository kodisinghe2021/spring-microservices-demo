package org.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class DepartmentDTO {
  private Long id;
  private String departmentName;
  private String departmentDescription;
  private String departmentCode;
}
