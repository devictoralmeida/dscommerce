package com.devsuperior.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
  private Long id;

  @NotBlank(message = "Campo requerido")
  private String name;
  private String email;

  private String phone;
  private LocalDate birthDate;
  private List<String> roles = new ArrayList<>();

  public UserDTO() {
  }

  public UserDTO(Long id, String name, String email, String phone, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.birthDate = birthDate;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public List<String> getRoles() {
    return this.roles;
  }

  public void setRoles(List<GrantedAuthority> roles) {
    for (GrantedAuthority role : roles) {
      this.roles.add(role.getAuthority());
    }
  }
}
