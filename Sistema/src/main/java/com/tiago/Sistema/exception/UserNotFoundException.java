package com.tiago.Sistema.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Usuario nao encontrado!");
    }
}
