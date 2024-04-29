package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;

  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  @GetMapping(value = "/{id}")
  public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(this.orderService.findById(id));
  }

  @PreAuthorize("hasRole('ROLE_CLIENT')")
  @PostMapping
  public ResponseEntity<OrderDTO> save(@Valid @RequestBody OrderDTO orderDTO) {
    OrderDTO dto = this.orderService.save(orderDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }
//
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  @PutMapping(value = "/{id}")
//  public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
//    return ResponseEntity.ok(this.productService.update(id, productDTO));
//  }
//
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  @DeleteMapping(value = "/{id}")
//  public ResponseEntity<Void> delete(@PathVariable Long id) {
//    this.productService.delete(id);
//    return ResponseEntity.noContent().build();
//  }
}
