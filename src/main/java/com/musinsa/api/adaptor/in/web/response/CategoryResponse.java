package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.CategoryItems;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
public class CategoryResponse {
    private String categoryName;
    private List<ItemResponse> lowestPrice;
    private List<ItemResponse> highestPrice;

    public static CategoryResponse toResponse(CategoryItems categoryItems) {

        return CategoryResponse.builder()
                .categoryName(categoryItems.getCategoryName())
                .lowestPrice(List.of(ItemResponse.builder().brandName("C").price("10,000").build()))
                .highestPrice(List.of(ItemResponse.builder().brandName("I").price("11,400").build()))
                .build();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static class ItemResponse {
        private String brandName;
        private String price;

        @Builder(access = AccessLevel.PRIVATE)
        private ItemResponse(String brandName, String price) {
            this.brandName = brandName;
            this.price = price;
        }
    }
}
