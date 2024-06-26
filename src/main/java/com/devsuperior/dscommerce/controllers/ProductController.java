package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductMinDTO;
import com.devsuperior.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<Page<ProductMinDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
    return ResponseEntity.ok(this.productService.findAll(name, pageable));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(this.productService.findById(id));
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping
  public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO) {
    // 1º Cria o produto
    ProductDTO dto = this.productService.save(productDTO);
    // 2º Cria a URI
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    // 3º Cria a responseEntity com a URI e o body como o dto retornado pelo service.
    return ResponseEntity.created(uri).body(dto);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
    return ResponseEntity.ok(this.productService.update(id, productDTO));
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
