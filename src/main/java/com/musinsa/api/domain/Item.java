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

    @Builder(access = AccessLevel.PRIVATE) // TODO builder의 엑세스레벨 통일
    private Item(Long id, Brand brand, Category category, ItemPrice price) {
        this.id = id;
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

    public static Item mapFromEntity(Long id, Brand brand, Category category, ItemPrice price) {
        return Item.builder()
                .id(id)
                .brand(brand) // TODO null 인 경우
                .category(category)
                .price(price)
                .build();
    }

    public String getItemBrandName() {
        return brand.getBrandName();
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
}
