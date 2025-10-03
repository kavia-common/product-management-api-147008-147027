package com.example.demo.product.controller;

import com.example.demo.product.model.Product;
import com.example.demo.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * REST Controller for Product CRUD operations.
 *
 * Base path: /api/products
 * Endpoints:
 * - POST /api/products: Create a product
 * - GET /api/products: List all products
 * - GET /api/products/{id}: Get a product by ID
 * - PUT /api/products/{id}: Update a product by ID
 * - DELETE /api/products/{id}: Delete a product by ID
 *
 * Notes:
 * - Uses @Valid for request body validation based on Product constraints.
 * - Returns appropriate HTTP status codes per REST conventions.
 */
@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * PUBLIC_INTERFACE
     * Create a new product.
     *
     * @param product Product payload (name, price, quantity)
     * @return Created product with generated id and 201 Created status.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Create product",
            description = "Creates a new product with the provided name, price, and quantity.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Product created",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content)
            }
    )
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * PUBLIC_INTERFACE
     * Retrieve all products.
     *
     * @return List of all products.
     */
    @GetMapping
    @Operation(
            summary = "List products",
            description = "Returns a list of all products.",
            responses = @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = Product.class)))
    )
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * PUBLIC_INTERFACE
     * Retrieve a single product by id.
     *
     * @param id Product identifier
     * @return Product if found; 404 if not.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get product by ID",
            description = "Returns a single product by its unique identifier.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            }
    )
    public ResponseEntity<Product> getById(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /**
     * PUBLIC_INTERFACE
     * Update an existing product by id.
     *
     * @param id      Product identifier
     * @param product Updated product data
     * @return Updated product
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Update product",
            description = "Updates a product by ID with the provided data.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product updated",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            }
    )
    public ResponseEntity<Product> update(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id,
            @Valid @RequestBody Product product) {
        return ResponseEntity.ok(service.update(id, product));
    }

    /**
     * PUBLIC_INTERFACE
     * Delete a product by id.
     *
     * @param id Product identifier
     * @return No content if successful.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete product",
            description = "Deletes a product by its ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Product deleted"),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            }
    )
    public ResponseEntity<Void> delete(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
