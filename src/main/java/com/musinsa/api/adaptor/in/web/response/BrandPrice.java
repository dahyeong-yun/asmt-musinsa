package com.musinsa.api.adaptor.in.web.response;

import lombok.Builder;

public class BrandPrice {
    private String brand;
    private String price;

    @Builder
    private BrandPrice(String brand, String price) {
        this.brand = brand;
        this.price = price;
    }
}
