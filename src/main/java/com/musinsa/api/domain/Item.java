package com.musinsa.api.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Item {
    private Long id;
    private Brand brand;
    private Category category;
    private ItemPrice price;

    @Builder(access = AccessLevel.PRIVATE)
    private Item(Brand brand, Category category, ItemPrice price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public static Item of(Brand brand, Category category, String number) {
        BigDecimal decimal = BigDecimal.valueOf(Double.parseDouble(number));
        return Item.builder()
                .brand(brand)
                .category(category)
                .price(ItemPrice.create(decimal))
                .build();
    }

    public String getItemCategoryName() {
        return category.getKorean();
    }

    public String getItemFormattedPrice() {
        return price.toFormattedString();
    }

    public BigDecimal getItemPrice() {
        return price.getPrice();
    }

    public static Item create(Brand brand, Category category, ItemPrice price) {
        return Item.builder()
                .brand(brand)
                .category(category)
                .price(price)
                .build();
    }

    public String getItemBrandName() {
        return brand.getBrandName();
    }
}
