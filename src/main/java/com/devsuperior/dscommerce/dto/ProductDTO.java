package com.devsuperior.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
  private Long id;

  // Not null trata apenas se o campo é nulo OU não foi enviado na req, já o NotBlank trata se o campo é nulo ou vazio
  @NotBlank(message = "Campo requerido")
  @Size(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres")
  private String name;

  @NotBlank(message = "Campo requerido")
  @Size(min = 10, message = "O campo deve ter no mínimo 10 caracteres")
  private String description;

  @Positive(message = "O preço deve ser um valor positivo")
  private Double price;
  private String imgUrl;

  public ProductDTO() {
  }

  public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
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

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return this.imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
