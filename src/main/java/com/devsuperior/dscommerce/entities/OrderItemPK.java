package com.devsuperior.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class OrderItemPK {
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public OrderItemPK() {

  }

  public Order getOrder() {
    return this.order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    OrderItemPK that = (OrderItemPK) o;
    return Objects.equals(this.order, that.order) && Objects.equals(this.product, that.product);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(this.order);
    result = 31 * result + Objects.hashCode(this.product);
    return result;
  }

  @Override
  public String toString() {
    return "OrderItemPK{" +
            "order=" + this.order +
            ", product=" + this.product +
            '}';
  }
}
