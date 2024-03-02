package org.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope(proxyMode = ScopedProxyMode.NO)
public class MessagePass {
  @Value("${spring.boot.message}")
  private String message;

  @GetMapping("employee/message")
  private String message(){
    return message;
  }
}
