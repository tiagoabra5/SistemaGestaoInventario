package com.tiago.Sistema.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Produto nao encontrado!");
    }

}
