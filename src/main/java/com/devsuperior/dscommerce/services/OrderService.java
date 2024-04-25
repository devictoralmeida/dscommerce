package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;

  public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
    this.orderRepository = orderRepository;
    this.modelMapper = modelMapper;
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = this.orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    return new OrderDTO(order);
  }

//  @Transactional
//  public OrderDTO save(OrderDTO orderDTO) {
//    Order orderEntity = this.modelMapper.map(orderDTO, Order.class);
//    this.createCategoriesEntity(orderDTO.getCategories(), orderEntity);
//    this.orderRepository.save(orderEntity);
//
//    return this.modelMapper.map(orderEntity, OrderDTO.class);
//  }
}
