package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;

public class CategoryDTO {
  private Long id;
  private String name;

  public CategoryDTO() {
  }

  public CategoryDTO(String name, Long id) {
    this.name = name;
    this.id = id;
  }

  public CategoryDTO(Category entity) {
    this.name = entity.getName();
    this.id = entity.getId();
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
}
