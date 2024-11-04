package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Item;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemRetrieveResponse {
    private final Long id;
    private final String brandName;
    private final String categoryName;
    private final String price;

    @Builder(access = AccessLevel.PRIVATE)
    private ItemRetrieveResponse(Long id, String brandName, String categoryName, String price) {
        this.id = id;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.price = price;
    }

    public static ItemRetrieveResponse of(Item item) {
        return ItemRetrieveResponse.builder()
                .id(item.getId())
                .brandName(item.getBrand().getBrandName())
                .categoryName(item.getItemCategoryName())
                .price(item.getItemFormattedPrice())
                .build();
    }
}
