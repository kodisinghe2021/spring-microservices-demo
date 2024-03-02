package org.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class EmployeeDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String departmentCode;
}
