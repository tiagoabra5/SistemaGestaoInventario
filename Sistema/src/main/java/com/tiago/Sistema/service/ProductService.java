package com.tiago.Sistema.service;

import org.springframework.stereotype.Service;
import com.tiago.Sistema.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    
}
