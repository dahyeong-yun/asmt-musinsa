package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.Items;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LowestPricesBrandMixResponse {
    private List<ItemResponse> categories;
    private String totalPrice;

    public static LowestPricesBrandMixResponse of(Items allCategoryItems) {
        List<Item> items = allCategoryItems.getItems();
        // items price 의 sum => totalPrice
        // items map => categories
        List<ItemResponse> categories =
                items.stream()
                        .map(item -> ItemResponse.builder()
                                .categoryName(item.getItemCategoryName())
                                .brandName(item.getItemBrandName())
                                .price(item.getItemFormattedPrice())
                                .build())
                        .collect(Collectors.toList());
        return new LowestPricesBrandMixResponse(
                categories,
                allCategoryItems.getTotalPrice()
        );
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class ItemResponse {
        private String categoryName;
        private String brandName;
        private String price;
    }
}

