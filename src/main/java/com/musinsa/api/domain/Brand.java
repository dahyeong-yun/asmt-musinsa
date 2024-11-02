package com.musinsa.api.domain;

import lombok.Builder;
import lombok.Getter;

public class Brand {
    @Getter
    private Long id;

    @Getter
    private String brandName;

    @Getter
    private String businessNumber;

    @Builder
    private Brand(Long id, String brandName, String businessNumber) {
        this.id = id;
        this.brandName = brandName;
        this.businessNumber = businessNumber;
    }

    public static Brand create(String brandName, String businessNumber) {
        // TODO: Add validation
        return Brand.builder()
                .brandName(brandName)
                .businessNumber(businessNumber)
                .build();
    }
}
