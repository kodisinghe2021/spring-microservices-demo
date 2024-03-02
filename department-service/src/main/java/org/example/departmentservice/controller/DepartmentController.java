package org.example.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.example.departmentservice.dto.DepartmentDTO;
import org.example.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {
  DepartmentService departmentService;
  @PostMapping("/save")
  public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
   DepartmentDTO d = departmentService.saveDepartment(departmentDTO);
    return new ResponseEntity<>(d, HttpStatus.CREATED);
  }

  @GetMapping(path="/{code}")
  public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable  String code){
   DepartmentDTO d = departmentService.getDepartmentByCode(code);
    return new ResponseEntity<>(d, HttpStatus.CREATED);
  }
}