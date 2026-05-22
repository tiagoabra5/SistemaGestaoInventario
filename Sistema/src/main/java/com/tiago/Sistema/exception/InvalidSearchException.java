package com.tiago.Sistema.exception;

public class InvalidSearchException extends RuntimeException{
    public InvalidSearchException(){
        super("Digite algo para realizar a busca");
    }
}
