package com.tiago.Sistema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.tiago.Sistema.service.ProductService;
import com.tiago.Sistema.entity.Product;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService ps;

    //listar todos
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = ps.findAll();
        return ResponseEntity.ok(products);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = ps.findById(id);
        return ResponseEntity.ok(product);
    }

    //buscar por nome
    @GetMapping("/search")
    public ResponseEntity<List<Product>> findByName(@RequestParam String name){
        List<Product> product = ps.findByName(name);
        return ResponseEntity.ok(product);
    }

    //criar/cadastrar produto
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = ps.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    //atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,  @RequestBody Product product){
        Product updatedProduct = ps.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    //deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        ps.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
