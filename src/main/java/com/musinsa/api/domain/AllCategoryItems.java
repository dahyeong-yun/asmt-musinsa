package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

// TODO 명칭 수정 : 하나의 브랜드 기준 전체 카테고리 상품들
@Getter
public class AllCategoryItems {

    private Brand brand;

    private Items items;

    @Builder(access = AccessLevel.PRIVATE)
    private AllCategoryItems(Brand brand, List<Item> items) {
        this.brand = brand;
        this.items = Items.create();
        items.forEach(this.items::add);
    }

    public static AllCategoryItems of(Brand brand, List<Item> items) {
        return new AllCategoryItems(brand, items);
    }

    public String getBrandName() {
        return brand.getBrandName();
    }

    public String getTotalPrice() {
        BigDecimal totalPrice = items.getItems().stream()
                .map(Item::getItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        ItemPrice itemsPrice = ItemPrice.create(totalPrice);
        return itemsPrice.toFormattedString();
    }
}
