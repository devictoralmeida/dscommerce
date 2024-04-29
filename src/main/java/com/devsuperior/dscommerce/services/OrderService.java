package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.dto.OrderItemDTO;
import com.devsuperior.dscommerce.entities.*;
import com.devsuperior.dscommerce.repositories.OrderItemRepository;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;
  private final OrderItemRepository orderItemRepository;
  private final UserService userService;
  private final AuthService authService;

  public OrderService(AuthService authService, UserService userService, OrderItemRepository orderItemRepository, ProductRepository productRepository, OrderRepository orderRepository) {
    this.authService = authService;
    this.userService = userService;
    this.orderItemRepository = orderItemRepository;
    this.productRepository = productRepository;
    this.orderRepository = orderRepository;
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = this.orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

    // Validando se o usuário logado é admin ou é o dono do pedido
    this.authService.validateSelfOrAdmin(order.getClient().getId());
    return new OrderDTO(order);
  }

  @Transactional
  public OrderDTO save(OrderDTO orderDTO) {
    User user = this.userService.autenticated();

    Order order = new Order();
    order.setMoment(Instant.now());
    order.setStatus(OrderStatus.WAITING_PAYMENT);
    order.setClient(user);

    for (OrderItemDTO itemDTO : orderDTO.getItems()) {
      Product product = this.productRepository.getReferenceById(itemDTO.getProductId());
      OrderItem orderItem = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());

      order.getItems().add(orderItem);
    }

    this.orderRepository.save(order);
    this.orderItemRepository.saveAll(order.getItems());
    return new OrderDTO(order);
  }
}
