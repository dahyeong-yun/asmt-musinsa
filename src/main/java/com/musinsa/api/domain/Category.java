package com.musinsa.api.domain;

import lombok.Getter;

@Getter
public enum Category {
    TOP("상의"),
    BOTTOM("하의"),
    OUTER("아우터"),
    SHOES("신발"),
    HAT("모자"),
    BAG("가방"),
    ACCESSORY("액세서리");

    private String name;

    Category(String name) {
        this.name = name;
    }

}
