package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Brand;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BrandRetrieveResponse {
    private final Long id;
    private final String brandName;

    @Builder(access = AccessLevel.PRIVATE)
    private BrandRetrieveResponse(Long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public static BrandRetrieveResponse of(Brand brand) {
        return BrandRetrieveResponse.builder()
                .id(brand.getId())
                .brandName(brand.getBrandName())
                .build();
    }
}
