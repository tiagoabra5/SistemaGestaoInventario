package com.tiago.Sistema.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.Sistema.dto.ProductRequestDTO;
import com.tiago.Sistema.dto.ProductResponseDTO;

import com.tiago.Sistema.entity.Product;
import com.tiago.Sistema.exception.InvalidSearchException;
import com.tiago.Sistema.exception.ProductNotFoundException;
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
            throw new InvalidSearchException();
        }
        return this.pr.findByNameContainingIgnoreCase(name);
    }   

    //buscar produto pelo ID
    public Product findById(Long id){
        return this.pr.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    //buscar todos os produtos
    public List<Product> findAll(){
        return this.pr.findAll();
    }

    //save produto - antigo - antes do dto
    /*public Product createProduct(ProductRequestDTO dto){
        dto.setCreatedAt(LocalDateTime.now());
        return this.pr.save(dto);
    }*/

    //save produto - novo - para o dto
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = new Product();
    
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCreatedAt(LocalDateTime.now());
    
        Product savedProduct = this.pr.save(product);
        return toResponseDTO(savedProduct);
    }

    //atualizar produto
    public Product updateProduct(Long id, ProductRequestDTO dto){
        Product productExisting = findById(id);
        productExisting.setName(dto.getName());
        productExisting.setDescription(dto.getDescription());
        productExisting.setPrice(dto.getPrice());
        productExisting.setQuantity(dto.getQuantity());
        return this.pr.save(productExisting);
    }

    //deletar produto
    public void deleteProduct(Long id){
        Product product = findById(id);
        this.pr.delete(product);
    }

    private ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getQuantity(),
            product.getCreatedAt()
        );
    }
    
}