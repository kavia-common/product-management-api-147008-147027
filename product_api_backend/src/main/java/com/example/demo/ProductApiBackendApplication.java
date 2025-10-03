package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PUBLIC_INTERFACE
 * Entry point for the Product API Backend.
 * This Spring Boot application exposes RESTful endpoints for managing products.
 *
 * Architecture:
 * - Model: Product (id, name, price, quantity)
 * - Repository: ProductRepository (JPA)
 * - Service: ProductService (business logic)
 * - Controller: ProductController (REST endpoints)
 * - Exception handling: GlobalExceptionHandler
 *
 * Ocean Professional style guide:
 * - Modern, clean organization
 * - Clear separation of concerns
 * - Rich inline documentation and readable code
 */
@SpringBootApplication
public class ProductApiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiBackendApplication.class, args);
    }
}
