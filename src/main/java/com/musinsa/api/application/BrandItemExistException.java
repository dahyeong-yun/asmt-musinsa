package com.musinsa.api.application;

public class BrandItemExistException extends RuntimeException {
    public BrandItemExistException(String message) {
        super(message);
    }
}
