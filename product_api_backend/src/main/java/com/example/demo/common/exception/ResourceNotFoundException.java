package com.example.demo.common.exception;

/**
 * PUBLIC_INTERFACE
 * Exception thrown when a requested resource cannot be found.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
