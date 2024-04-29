package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.CategoryDTO;
import com.devsuperior.dscommerce.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;
  private final ModelMapper modelMapper;

  public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
    this.categoryRepository = categoryRepository;
    this.modelMapper = modelMapper;
  }

  @Transactional(readOnly = true)
  public List<CategoryDTO> findAll() {
    return this.categoryRepository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
  }
}
