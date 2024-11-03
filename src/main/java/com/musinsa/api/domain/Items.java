package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

// TODO 명칭 수정 : 전체 카테고리 별 각 가장 저렴한 상품
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Items {
    private List<Item> items;

    public void add(Item item) {
        items.add(item);
    }

    public static Items create(List<Item> items) {
        return new Items(items);
    }

    public Item findLowestPriceItem() {
        return items.stream()
                .min(Comparator.comparing(Item::getItemPrice))
                .orElseThrow();
    }

    public Item findHighestPriceItem() {
        return items.stream()
                .max(Comparator.comparing(Item::getItemPrice))
                .orElseThrow();
    }

    public String getTotalPrice() {
        BigDecimal totalPrice = items.stream()
                .map(Item::getItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        ItemPrice itemsPrice = ItemPrice.create(totalPrice);
        return itemsPrice.toFormattedString();
    }
}
