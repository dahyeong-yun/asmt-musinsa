package com.musinsa.api.adaptor.in.web.response;

import lombok.Builder;

public class BrandPrice {
    private String brandName;
    private String price; // TODO 천단위 구분자를 표현하는 타입으로 변경

    @Builder
    private BrandPrice(String brandName, String price) {
        this.brandName = brandName;
        this.price = price;
    }
}
