package com.musinsa.api.domain;

// TODO 명칭 수정 : 하나의 카테고리 기준 가장 비싼 상품, 가장 저렴한 상품
public class CategoryItems {
    private Category category;
    private Items items;

    public String getCategoryName() {
        return category.getKorean();
    }

    // TODO getHighestPriceItem, getLowestPriceItem 메서드 추가
}
