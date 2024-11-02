package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AllCategoryItems {

    private Brand brand;

    private Items items;

    @Builder(access = AccessLevel.PRIVATE)
    private AllCategoryItems(Brand brand, List<Item> items) {
        this.brand = brand;
        this.items = new Items();
        items.forEach(this.items::add);
    }

    public static AllCategoryItems of(Brand brand, List<Item> items) {
        return new AllCategoryItems(brand, items);
    }

    public String getBrandName() {
        return brand.getBrandName();
    }
}
