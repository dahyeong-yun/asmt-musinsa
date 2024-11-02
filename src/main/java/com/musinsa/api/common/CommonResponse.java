package com.musinsa.api.common;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CommonResponse<T> extends ResponseEntity<T> {
    private String code;
    private String message;

    public CommonResponse(HttpStatusCode status) {
        super(status);
    }

    public CommonResponse(Object body, HttpStatusCode status) {
        super((T) body, status);
    }

    public CommonResponse(MultiValueMap headers, HttpStatusCode status) {
        super(headers, status);
    }
}
