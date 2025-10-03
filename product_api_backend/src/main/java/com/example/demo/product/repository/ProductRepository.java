package com.example.demo.product.repository;

import com.example.demo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PUBLIC_INTERFACE
 * Repository for Product entities.
 *
 * Extends JpaRepository to provide CRUD operations out of the box.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
