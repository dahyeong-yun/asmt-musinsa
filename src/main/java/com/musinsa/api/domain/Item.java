package com.musinsa.api.domain;


import lombok.Builder;
import lombok.Getter;

public class Item {
    private Long id;
    private Brand brand;
    private Category category;
    @Getter
    private ItemPrice price;

    @Builder
    private Item(Brand brand, Category category, ItemPrice price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public static Item create(Brand brand, Category category, ItemPrice price) {
        return Item.builder()
                .brand(brand)
                .category(category)
                .price(price)
                .build();
    }

}
