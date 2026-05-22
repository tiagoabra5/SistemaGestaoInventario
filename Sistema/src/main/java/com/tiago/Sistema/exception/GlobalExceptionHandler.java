package com.tiago.Sistema.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFound(ProductNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidSearchException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidSearch(InvalidSearchException ex) {
        Map<String, Object> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("status", 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}