package com.tiago.Sistema.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.Sistema.entity.Product;
import com.tiago.Sistema.repository.ProductRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository pr;

    //buscar produto pelo nome
    public List<Product> findByName(String name){
        if(name == null || name.isBlank()){
            throw new RuntimeException("Digite algo para realizar a busca");
        }
        return this.pr.findByNameContainingIgnoreCase(name);
    }   

    //buscar produto pelo ID
    public Product findById(Long id){
        return this.pr.findById(id).orElseThrow(() -> new RuntimeException("ID nao encontrado! ID: " + id));
    }

    //buscar todos os produtos
    public List<Product> findAll(){
        return this.pr.findAll();
    }

    //save produto
    public Product createProduct(Product product){
        product.setCreatedAt(LocalDateTime.now());
        return this.pr.save(product);
    }

    //atualizar produto
    public Product updateProduct(Long id, Product product){
        Product productExisting = findById(id);
        productExisting.setName(product.getName());
        productExisting.setDescription(product.getDescription());
        productExisting.setPrice(product.getPrice());
        productExisting.setQuantity(product.getQuantity());
        return this.pr.save(productExisting);
    }

    //deletar produto
    public void deleteProduct(Long id){
        Product product = findById(id);
        this.pr.delete(product);
    }
    
}