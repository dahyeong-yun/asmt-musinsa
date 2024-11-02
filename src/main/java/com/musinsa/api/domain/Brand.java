package com.musinsa.api.domain;

import lombok.Builder;
import lombok.Getter;

public class Brand {
    @Getter
    private Long id;

    @Getter
    private String brandName;


    @Builder
    private Brand(Long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public static Brand create(String brandName) {
        // TODO: Add validation
        return Brand.builder()
                .brandName(brandName)
                .build();
    }
}
