package com.mitocode.exception;

public class DomainCustomException extends RuntimeException{
    public DomainCustomException(String message) {
        super(message);
    }
}
