package org.example.employeeservice.service;

import org.example.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "DEPARTMENT-SERVICE")
//@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APICloudClient {
  @GetMapping(path="/api/department/{code}")
   DepartmentDTO getDepartmentByCode(@PathVariable String code);
}
