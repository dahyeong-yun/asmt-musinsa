package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Item;
import lombok.Builder;

import java.util.List;

@Builder
public class CategoryResponse {
    private String categoryName;
    private List<BrandPrice> lowestPrice;
    private List<BrandPrice> highestPrice;

    public static CategoryResponse toResponse(String categoryName) {
        return CategoryResponse.builder()
                .categoryName(categoryName)
                .lowestPrice(List.of(BrandPrice.builder().brandName("C").price("10,000").build()))
                .highestPrice(List.of(BrandPrice.builder().brandName("I").price("11,400").build()))
                .build();
    }
}
