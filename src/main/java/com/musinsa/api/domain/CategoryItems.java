package com.musinsa.api.domain;

public class CategoryItems {
    private Category category;
    private Items items;

    public String getCategoryName() {
        return category.getKorean();
    }
}
