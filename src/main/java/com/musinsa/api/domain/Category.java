package com.musinsa.api.domain;

import lombok.Getter;

@Getter
public enum Category {
    TOP("상의"),
    OUTER("아우터"),
    PANTS("바지"),
    SNEAKERS("스니커즈"),
    BAG("가방"),
    CAP("모자"),
    SOCKS("양말"),
    ACCESSORY("액세서리");

    private final String korean;

    Category(String korean) {
        this.korean = korean;
    }

    public static Category fromString(String value) {
        if (value == null) {
            throw new WrongCategoryException("Category value cannot be null");
        }

        return switch (value.toUpperCase()) {
            case "상의" -> TOP;
            case "아우터" -> OUTER;
            case "바지" -> PANTS;
            case "스니커즈" -> SNEAKERS;
            case "가방" -> BAG;
            case "모자" -> CAP;
            case "양말" -> SOCKS;
            case "액세서리" -> ACCESSORY;
            default -> throw new IllegalArgumentException("Invalid category: " + value);
        };
    }
}
