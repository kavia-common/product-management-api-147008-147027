package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Lightweight utility controller for health and docs redirection.
 * Not part of core product CRUD, but useful for quick checks.
 */
@RestController
@Tag(name = "Utility", description = "Basic health and docs endpoints")
public class HelloController {

    @GetMapping("/")
    @Operation(summary = "Welcome", description = "Returns a friendly welcome message.")
    public String hello() {
        return "Hello, Spring Boot! Welcome to Product API Backend.";
    }

    @GetMapping("/docs")
    @Operation(summary = "API Documentation", description = "Redirects to Swagger UI.")
    public RedirectView docs() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Returns application health status.")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/info")
    @Operation(summary = "Application info", description = "Returns application information.")
    public String info() {
        return "Spring Boot Application: Product API Backend";
    }
}