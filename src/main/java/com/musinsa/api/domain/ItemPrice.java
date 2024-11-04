package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ItemPrice {
    @Getter
    private BigDecimal price;

    @Builder(access = AccessLevel.PRIVATE)
    private ItemPrice(BigDecimal price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(BigDecimal price) {
        if (price != null) {
            if (price.compareTo(BigDecimal.ZERO) < 0) {
                throw new InvalidPriceException("상품 가격은 0원 이상이어야 합니다.");
            }
        }
    }

    public static ItemPrice create(BigDecimal price) {
        return ItemPrice.builder()
                .price(price)
                .build();
    }

    public String toFormattedString() {
        if (price == null) {
            return "0";
        }
        return NumberFormat.getInstance(Locale.KOREA)
                .format(price);
    }
}
