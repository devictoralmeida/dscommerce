package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
  private Long productId;
  private String name;
  private String imgUrl;
  private Double price;
  private Integer quantity;

  public OrderItemDTO() {
  }

  public OrderItemDTO(Long productId, String name, String imgUrl, Double price, Integer quantity) {
    this.productId = productId;
    this.name = name;
    this.imgUrl = imgUrl;
    this.price = price;
    this.quantity = quantity;
  }

  public OrderItemDTO(OrderItem entity) {
    this.productId = entity.getProduct().getId();
    this.name = entity.getProduct().getName();
    this.imgUrl = entity.getProduct().getImgUrl();
    this.price = entity.getPrice();
    this.quantity = entity.getQuantity();
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
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

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getImgUrl() {
    return this.imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Double getSubtotal() {
    return this.price * this.quantity;
  }
}
