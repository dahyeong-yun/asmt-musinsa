package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Brand;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BrandRetrieveResponse {
    private final String brandName;
    private final String businessNumber;

    @Builder
    private BrandRetrieveResponse(String brandName, String businessNumber) {
        this.brandName = brandName;
        this.businessNumber = businessNumber;
    }

    public static BrandRetrieveResponse of(Brand brand) {
        return BrandRetrieveResponse.builder()
                .brandName(brand.getBrandName())
                .businessNumber(brand.getBusinessNumber())
                .build();
    }
}
