package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.CategoryItems;
import com.musinsa.api.domain.Item;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class CategoryResponse {
    private String categoryName;
    private List<ItemResponse> lowestPrice;
    private List<ItemResponse> highestPrice;

    public static CategoryResponse of(CategoryItems categoryItems) {
        Item lowestPriceItem = categoryItems.getLowestPriceItem();
        Item higestPriceItem = categoryItems.getHighestPriceItem();

        return CategoryResponse.builder()
                .categoryName(categoryItems.getCategoryName())
                .lowestPrice(List.of(ItemResponse.of(lowestPriceItem)))
                .highestPrice(List.of(ItemResponse.of(higestPriceItem)))
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

        public static ItemResponse of(Item item) {
            return ItemResponse.builder()
                    .brandName(item.getItemBrandName())
                    .price(item.getItemFormattedPrice())
                    .build();
        }
    }
}
