package com.musinsa.api.domain;

public class WrongCategoryException extends RuntimeException { // TODO 도메인 계층 공통 예외로 변경
    public WrongCategoryException(String message) {
        super(message);
    }
}
