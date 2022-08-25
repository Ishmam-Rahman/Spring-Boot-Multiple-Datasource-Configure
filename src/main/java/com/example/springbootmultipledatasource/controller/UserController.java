package com.example.springbootmultipledatasource.controller;

import com.example.springbootmultipledatasource.entity.member.Member;
import com.example.springbootmultipledatasource.entity.product.Product;
import com.example.springbootmultipledatasource.repository.member.UserRepository;
import com.example.springbootmultipledatasource.repository.product.ProductRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  public UserController(UserRepository userRepository, ProductRepository productRepository) {
    this.userRepository = userRepository;
    this.productRepository = productRepository;
  }

  @PostMapping("/member")
  public Member createUser(Member user){
    return userRepository.save(user);
  }

  @GetMapping("/member")
  public List<Member> getUsers(){
    return userRepository.findAll();
  }

  @PostMapping("/product")
  public Product createProduct(Product user){
    return productRepository.save(user);
  }

  @GetMapping("/product")
  public List<Product> getProducts(){
    return productRepository.findAll();
  }
}
