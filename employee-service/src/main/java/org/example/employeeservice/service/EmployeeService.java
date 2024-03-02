package org.example.employeeservice.service;

import org.example.employeeservice.dto.EmployeeDTO;
import org.example.employeeservice.dto.GetEmployeeWithDep;
import org.example.employeeservice.dto.ResEmployeeWithDep;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

 EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

 EmployeeDTO getEmployeeByEmail(String email );

 ResEmployeeWithDep getEmployeeWithDepartment(String email);
}
