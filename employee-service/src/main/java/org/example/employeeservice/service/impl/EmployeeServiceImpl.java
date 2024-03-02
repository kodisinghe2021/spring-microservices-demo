package org.example.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.example.employeeservice.dto.DepartmentDTO;
import org.example.employeeservice.dto.EmployeeDTO;
import org.example.employeeservice.dto.ResEmployeeWithDep;
import org.example.employeeservice.entity.Employee;
import org.example.employeeservice.repository.EmployeeRepo;
import org.example.employeeservice.service.APICloudClient;
import org.example.employeeservice.service.EmployeeService;
import org.example.employeeservice.util.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepo employeeRepo;
  private WebClient webClient;
  private EmployeeMapper employeeMapper;
  private APICloudClient apiCloudClient;
  @Override
  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
    if (!employeeRepo.existsByEmailEquals(employeeDTO.getEmail())) {
      Employee e = employeeRepo.save(new Employee(
              employeeDTO.getId(),
              employeeDTO.getFirstName(),
              employeeDTO.getLastName(),
              employeeDTO.getEmail(),
              employeeDTO.getDepartmentCode()
      ));
      return new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getDepartmentCode());
    } else {
      return null;
    }
  }
  @Override
  public EmployeeDTO getEmployeeByEmail(String email) {
    if (employeeRepo.existsByEmailEquals(email)) {
      try {
        return employeeMapper.entityToDto(employeeRepo.findByEmailEquals(email));
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
    return null;
  }

  @Override
  public ResEmployeeWithDep getEmployeeWithDepartment(String email) {
    if (employeeRepo.existsByEmailEquals(email)) {
      Employee e = employeeRepo.findByEmailEquals(email);
     DepartmentDTO dto = apiCloudClient.getDepartmentByCode(e.getDepartmentCode());
      return new ResEmployeeWithDep(
              employeeMapper.entityToDto(e),
              dto
      );
    }
    return null;
  }
}
