package com.hexagonal.ArquiteturaHexagonal.core.shared.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }
}
