package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;
  private String phone;
  private LocalDate birthDate;
  private String password;

  @OneToMany(mappedBy = "client")
  private List<Order> orders = new ArrayList<>();

  public User() {
  }

  public User(Long id, String password, String name, String email, String phone, LocalDate birthDate) {
    this.id = id;
    this.password = password;
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

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Order> getOrders() {
    return this.orders;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + this.id +
            ", name='" + this.name + '\'' +
            ", email='" + this.email + '\'' +
            ", phone='" + this.phone + '\'' +
            ", birthDate=" + this.birthDate +
            ", password='" + this.password + '\'' +
            '}';
  }
}
