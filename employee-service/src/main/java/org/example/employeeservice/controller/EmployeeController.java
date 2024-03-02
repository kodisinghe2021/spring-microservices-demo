package org.example.employeeservice.controller;

import lombok.AllArgsConstructor;
import org.example.employeeservice.dto.EmployeeDTO;
import org.example.employeeservice.dto.ResEmployeeWithDep;
import org.example.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
  private EmployeeService employeeService;

  @PostMapping("/save")
  public ResponseEntity<EmployeeDTO> saveDepartment(@RequestBody EmployeeDTO employeeDTO) {
    EmployeeDTO e = employeeService.saveEmployee(employeeDTO);
    return new ResponseEntity<>(e, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{email}")
  public ResponseEntity<EmployeeDTO> getEmployeeByEmail(
          @PathVariable String email
  ) {
    EmployeeDTO d = employeeService.getEmployeeByEmail(email);
    return new ResponseEntity<>(d, HttpStatus.CREATED);
  }

  @GetMapping(path = "/with-department/{email}")
  public ResponseEntity<ResEmployeeWithDep> getEmployeeWithDepartment(
          @PathVariable String email
  ) {
    ResEmployeeWithDep d = employeeService.getEmployeeWithDepartment(email);
    return new ResponseEntity<>(d, HttpStatus.CREATED);
  }
}
