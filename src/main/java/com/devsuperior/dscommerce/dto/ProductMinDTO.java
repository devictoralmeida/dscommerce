package com.devsuperior.dscommerce.dto;

public class ProductMinDTO {
  private Long id;
  private String name;
  private Double price;
  private String imgUrl;

  public ProductMinDTO() {
  }

  public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
    this.id = id;
    this.name = name;
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
