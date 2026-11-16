package com.example.SecureProductApi.repository;

import com.example.SecureProductApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}