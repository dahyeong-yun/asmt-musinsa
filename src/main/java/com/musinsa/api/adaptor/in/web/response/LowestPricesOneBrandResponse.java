package com.musinsa.api.adaptor.in.web.response;

import com.musinsa.api.domain.AllCategoryItems;
import com.musinsa.api.domain.Item;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LowestPricesOneBrandResponse {
    private String brandName;
    private List<ItemResponse> categories;
    private String totalPrice;

    public static LowestPricesOneBrandResponse of(AllCategoryItems allCategoryItems) {
        List<Item> items = allCategoryItems.getItems().getItems();
        // items price 의 sum => totalPrice
        // items map => categories
        List<ItemResponse> categories =
                items.stream()
                        .map(item -> ItemResponse.builder()
                                .categoryName(item.getItemCategoryName())
                                .price(item.getItemFormattedPrice())
                                .build())
                        .collect(Collectors.toList());
        return new LowestPricesOneBrandResponse(
                allCategoryItems.getBrandName(),
                categories,
                "10000"
        );
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class ItemResponse {
        private String categoryName;
        private String price;
    }
}

