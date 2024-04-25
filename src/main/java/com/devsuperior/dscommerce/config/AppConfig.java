package com.devsuperior.dscommerce.config;

import com.devsuperior.dscommerce.dto.CategoryDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductMinDTO;
import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.entities.Category;
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
            .addMapping(Product::getImgUrl, ProductDTO::setImgUrl)
            .addMapping(Product::getCategories, ProductDTO::setCategories);

    modelMapper.createTypeMap(Product.class, ProductMinDTO.class)
            .addMapping(Product::getId, ProductMinDTO::setId)
            .addMapping(Product::getName, ProductMinDTO::setName)
            .addMapping(Product::getPrice, ProductMinDTO::setPrice)
            .addMapping(Product::getImgUrl, ProductMinDTO::setImgUrl);

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

    modelMapper.createTypeMap(Category.class, CategoryDTO.class)
            .addMapping(Category::getId, CategoryDTO::setId)
            .addMapping(Category::getName, CategoryDTO::setName);

    modelMapper.createTypeMap(CategoryDTO.class, Category.class)
            .addMapping(CategoryDTO::getId, Category::setId)
            .addMapping(CategoryDTO::getName, Category::setName);

//    modelMapper.createTypeMap(OrderDTO.class, Order.class)
//            .addMappings(mapper -> mapper.skip(Order::setId))
//            .addMapping(OrderDTO::getMoment, Order::setMoment)
//            .addMapping(OrderDTO::getStatus, Order::setStatus)
//            .addMapping(OrderDTO::getClient, Order::setClient)
//            .addMapping(OrderDTO::getPayment, Order::setPayment);

//    modelMapper.createTypeMap(OrderItemDTO.class, OrderItem.class)
//            .addMappings(mapper -> mapper.skip(OrderItem::setId))
//            .addMapping(OrderItemDTO::getProductId, Order::setProduct)
//            .addMapping(OrderItemDTO::getName, Order::setStatus)
//            .addMapping(OrderItemDTO::getPrice, Order::setClient)
//            .addMapping(OrderItemDTO::getQuantity, Order::setPayment);

    return modelMapper;
  }
}
