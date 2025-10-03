package com.example.demo.product.service;

import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.product.model.Product;
import com.example.demo.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * Service layer for Product operations.
 *
 * Responsibilities:
 * - Encapsulate repository calls
 * - Apply transactional boundaries
 * - Handle not-found scenarios
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public Product create(Product product) {
        return repository.save(product);
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id=" + id));
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return repository.findAll();
    }

    // PUBLIC_INTERFACE
    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        Product existing = getById(id);
        repository.delete(existing);
    }
}
