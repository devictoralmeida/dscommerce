package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "categories")
  private Set<Product> products = new HashSet<>();

  public Category() {

  }

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
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

  public Set<Product> getProducts() {
    return this.products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Category category = (Category) o;
    return Objects.equals(this.id, category.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.id);
  }

  @Override
  public String toString() {
    return "Category{" +
            "id=" + this.id +
            ", name='" + this.name + '\'' +
            ", products=" + this.products +
            '}';
  }
}
