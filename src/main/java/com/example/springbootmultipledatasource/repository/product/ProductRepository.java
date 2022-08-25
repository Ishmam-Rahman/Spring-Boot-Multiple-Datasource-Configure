package com.example.springbootmultipledatasource.repository.product;

import com.example.springbootmultipledatasource.entity.member.Member;
import com.example.springbootmultipledatasource.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
