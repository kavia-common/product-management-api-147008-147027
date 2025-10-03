package com.example.demo.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * PUBLIC_INTERFACE
 * Product entity representing an item in the catalog.
 *
 * Fields:
 * - id: unique identifier (Long, generated)
 * - name: product name (String, required, 1-255 chars)
 * - price: product price (BigDecimal, non-negative, up to 2 decimals)
 * - quantity: available units (Integer, non-negative)
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must be at most 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be non-negative")
    @Digits(integer = 12, fraction = 2, message = "Price must have up to 2 decimal places")
    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be non-negative")
    @Column(nullable = false)
    private Integer quantity;

    public Product() {
        // Default constructor for JPA
    }

    public Product(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    // No setter for id; it is generated

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
