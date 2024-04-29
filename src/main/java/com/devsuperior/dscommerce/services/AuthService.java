package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private final UserService userService;

  public AuthService(UserService userService) {
    this.userService = userService;
  }

  public void validateSelfOrAdmin(Long userId) {
    User loggedUser = this.userService.autenticated();
    if (!loggedUser.getId().equals(userId) && !loggedUser.hasRole("ROLE_ADMIN")) {
      throw new ForbiddenException("Acesso negado!");
    }
  }
}
