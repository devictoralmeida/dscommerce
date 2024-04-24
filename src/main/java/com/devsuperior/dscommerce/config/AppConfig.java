package com.devsuperior.dscommerce.config;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.createTypeMap(ProductDTO.class, Product.class)
            .addMappings(mapper -> mapper.skip(Product::setId))
            .addMapping(ProductDTO::getName, Product::setName)
            .addMapping(ProductDTO::getDescription, Product::setDescription)
            .addMapping(ProductDTO::getPrice, Product::setPrice)
            .addMapping(ProductDTO::getImgUrl, Product::setImgUrl);

    modelMapper.createTypeMap(Product.class, ProductDTO.class)
            .addMapping(Product::getId, ProductDTO::setId)
            .addMapping(Product::getName, ProductDTO::setName)
            .addMapping(Product::getDescription, ProductDTO::setDescription)
            .addMapping(Product::getPrice, ProductDTO::setPrice)
            .addMapping(Product::getImgUrl, ProductDTO::setImgUrl);

    modelMapper.createTypeMap(UserDTO.class, User.class)
            .addMappings(mapper -> mapper.skip(User::setId))
            .addMapping(UserDTO::getName, User::setName)
            .addMapping(UserDTO::getEmail, User::setEmail)
            .addMapping(UserDTO::getPhone, User::setPhone)
            .addMapping(UserDTO::getBirthDate, User::setBirthDate);

    modelMapper.createTypeMap(User.class, UserDTO.class)
            .addMapping(User::getId, UserDTO::setId)
            .addMapping(User::getName, UserDTO::setName)
            .addMapping(User::getEmail, UserDTO::setEmail)
            .addMapping(User::getPhone, UserDTO::setPhone)
            .addMapping(User::getBirthDate, UserDTO::setBirthDate)
            .addMapping(User::getRoles, UserDTO::setRoles);

    return modelMapper;
  }
}
