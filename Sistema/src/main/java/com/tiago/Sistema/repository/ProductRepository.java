package com.tiago.Sistema.repository;

import com.tiago.Sistema.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

        List<Product> findByNameContainingIgnoreCase(String name);

}