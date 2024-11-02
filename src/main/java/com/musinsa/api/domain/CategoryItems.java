package com.musinsa.api.domain;

import lombok.AccessLevel;
import lombok.Builder;

// TODO 명칭 수정 : 하나의 카테고리 기준 가장 비싼 상품, 가장 저렴한 상품
public class CategoryItems {
    private final Category category;
    private Items items;

    @Builder(access = AccessLevel.PRIVATE)
    private CategoryItems(Category category, Items items) {
        this.category = category;
        this.items = items;
    }

    public static CategoryItems of(Category category, Items items) {
        return new CategoryItems(category, items);
    }

    public String getCategoryName() {
        return category.getKorean();
    }

    // TODO getHighestPriceItem, getLowestPriceItem 메서드 추가
}
