package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public class ItemPrice {
    @Getter
    private BigDecimal price;

    @Builder(access = AccessLevel.PRIVATE)
    private ItemPrice(BigDecimal price) {
        // TODO 양수만 가능
        this.price = price;
    }

    public static ItemPrice create(BigDecimal price) {
        return ItemPrice.builder()
                .price(price)
                .build();
    }
}
