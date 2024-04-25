package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping(value = "/{id}")
  public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(this.orderService.findById(id));
  }

//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  @PostMapping
//  public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO) {
//    // 1º Cria o produto
//    ProductDTO dto = this.productService.save(productDTO);
//    // 2º Cria a URI
//    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//    // 3º Cria a responseEntity com a URI e o body como o dto retornado pelo service.
//    return ResponseEntity.created(uri).body(dto);
//  }
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
