package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Brand {
    private final Long id;

    private String brandName;

    @Builder(access = AccessLevel.PRIVATE)
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

    public static Brand mapFromEntity(Long id, String brandName) {
        return Brand.builder()
                .id(id)
                .brandName(brandName)
                .build();
    }

    public void updateBrandName(String brandName) {
        this.brandName = brandName;
    }
}
