package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(unique = true)
  private String email;

  private String phone;
  private LocalDate birthDate;
  private String password;

  @OneToMany(mappedBy = "client")
  private List<Order> orders = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "tb_user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

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

  public Set<Role> getRoles() {
    return this.roles;
  }

  public void addRole(Role role) {
    this.roles.add(role);
  }

  public boolean hasRole(String roleName) {
    for (Role role : this.roles) {
      if (role.getAuthority().equals(roleName)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;
    return Objects.equals(this.id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.id);
  }
}
