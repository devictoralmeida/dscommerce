package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
  // Os métodos customizados que iremos criar irá começar com search
  @Query(value = "SELECT obj FROM Product obj WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
  Page<Product> searchByName(String name, Pageable pageable);
}
