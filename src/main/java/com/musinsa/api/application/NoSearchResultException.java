package com.musinsa.api.application;

// TODO 패키지 위치 결정 및 핸들러 구현
public class NoSearchResultException extends RuntimeException {
    public NoSearchResultException(String message) {
        super(message);
    }
}
