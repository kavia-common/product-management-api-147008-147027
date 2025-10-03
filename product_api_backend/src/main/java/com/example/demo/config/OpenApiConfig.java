package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * PUBLIC_INTERFACE
 * OpenAPI configuration for the Product API.
 *
 * Provides top-level metadata for Swagger UI and API docs.
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Product Management API",
                version = "0.1.0",
                description = "REST API to perform CRUD operations on products"
        )
)
public class OpenApiConfig {
    // No additional configuration required for this simple setup.
}
