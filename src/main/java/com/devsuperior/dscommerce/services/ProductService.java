package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;

  public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(String name, Pageable pageable) {
    Page<Product> result = this.productRepository.searchByName(name, pageable);
    return result.map(product -> this.modelMapper.map(product, ProductDTO.class));
  }

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Product product = this.productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    return this.modelMapper.map(product, ProductDTO.class);
  }

  @Transactional
  public ProductDTO save(ProductDTO productDTO) {
    Product productEntity = this.modelMapper.map(productDTO, Product.class);
    productEntity = this.productRepository.save(productEntity);
    return this.modelMapper.map(productEntity, ProductDTO.class);
  }

  @Transactional
  public ProductDTO update(Long id, ProductDTO productDTO) {
    // Aqui tá com try catch pq o problema é na hora de chamar os save do repository.
    try {
      // O getReferenceById não vai no banco de dados, ele prepara o obj monitorado pela JPA
      // Instanciando com a referência
      Product entity = this.productRepository.getReferenceById(id);
      // Atualizando os dados do obj monitorado
      this.modelMapper.map(productDTO, entity);
      // Salvando no banco de dados
      entity = this.productRepository.save(entity);
      // Retornando o DTO
      return this.modelMapper.map(entity, ProductDTO.class);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Produto não encontrado");
    }
  }

  // Esse propagation é necessário por uma das exceções é à nivel de banco de dados.
  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    // Checar se existe o produto com o id recebido.
    if (!this.productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Produto não encontrado");
    }
    // Caso tenha um pedido associado ao produto, pode dar erro de integridade, então é necessário tratar.

    try {
      this.productRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      // Vamos lançar essa exceção personalizada.
      throw new DatabaseException("Falha de integridade referencial");
    }
  }
}
