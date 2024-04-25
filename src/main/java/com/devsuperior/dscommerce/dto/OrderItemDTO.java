package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
  private Long productId;
  private String name;
  private Double price;
  private Integer quantity;

  public OrderItemDTO() {
  }

  public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public OrderItemDTO(OrderItem entity) {
    this.productId = entity.getProduct().getId();
    this.name = entity.getProduct().getName();
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

  public Double getSubtotal() {
    return this.price * this.quantity;
  }
}
