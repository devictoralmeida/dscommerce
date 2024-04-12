package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;

  public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;

  }

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Optional<Product> result = this.productRepository.findById(id);
    Product product = result.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    return this.modelMapper.map(product, ProductDTO.class);
  }
}
