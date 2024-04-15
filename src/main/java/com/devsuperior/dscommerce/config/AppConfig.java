package com.devsuperior.dscommerce.config;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.createTypeMap(Product.class, ProductDTO.class)
            .addMapping(Product::getId, ProductDTO::setId)
            .addMapping(Product::getName, ProductDTO::setName)
            .addMapping(Product::getDescription, ProductDTO::setDescription)
            .addMapping(Product::getPrice, ProductDTO::setPrice)
            .addMapping(Product::getImgUrl, ProductDTO::setImgUrl);

    return modelMapper;
  }
}
