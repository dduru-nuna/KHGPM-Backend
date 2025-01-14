package com.example.demo.domain.product.repository;

import com.example.demo.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join p.productImgList pil where p.productId = :id")
    Optional<Product> findImgPathById(Long id);
}