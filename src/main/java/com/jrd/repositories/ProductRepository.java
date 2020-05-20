package com.jrd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrd.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }
