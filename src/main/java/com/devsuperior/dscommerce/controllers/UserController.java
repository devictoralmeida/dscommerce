package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  @GetMapping(value = "/me")
  public ResponseEntity<UserDTO> getUser() {
    return ResponseEntity.ok(this.userService.getUser());
  }
}
