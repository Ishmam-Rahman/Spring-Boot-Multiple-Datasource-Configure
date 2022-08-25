package com.example.springbootmultipledatasource.entity.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

  @Id
  private Long id;

  private String name;

  private Long quantity;

  private Long soldOut;

  private Long rating;
}
