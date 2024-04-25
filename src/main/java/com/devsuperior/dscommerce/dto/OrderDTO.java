package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
  private Long id;
  private Instant moment;
  private OrderStatus status;
  private ClientDTO client;
  private PaymentDTO payment;

  @NotEmpty(message = "A lista de produtos não pode ser vazia.")
  private List<OrderItemDTO> items = new ArrayList<>();

  public OrderDTO() {
  }

  public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
    this.payment = payment;
  }

  public OrderDTO(Order entity) {
    this.id = entity.getId();
    this.moment = entity.getMoment();
    this.status = entity.getStatus();
    this.client = new ClientDTO(entity.getClient());
    this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());

    for (OrderItem item : entity.getItems()) {
      this.items.add(new OrderItemDTO(item));
    }
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return this.moment;
  }

  public void setMoment() {
    this.moment = Instant.now();
  }

  public OrderStatus getStatus() {
    return this.status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public ClientDTO getClient() {
    return this.client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

  public PaymentDTO getPayment() {
    return this.payment;
  }

  public void setPayment(PaymentDTO payment) {
    this.payment = payment;
  }

  public List<OrderItemDTO> getItems() {
    return this.items;
  }

  public Double getTotal() {
    double sum = 0.0;
    for (OrderItemDTO item : this.items) {
      sum += item.getSubtotal();
    }
    return sum;
  }
}
