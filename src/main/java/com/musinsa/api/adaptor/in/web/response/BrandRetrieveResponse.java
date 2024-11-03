package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Brand;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BrandRetrieveResponse {
    private final String brandName;

    @Builder(access = AccessLevel.PRIVATE)
    private BrandRetrieveResponse(String brandName) {
        this.brandName = brandName;
    }

    public static BrandRetrieveResponse of(Brand brand) {
        return BrandRetrieveResponse.builder()
                .brandName(brand.getBrandName())
                .build();
    }
}
