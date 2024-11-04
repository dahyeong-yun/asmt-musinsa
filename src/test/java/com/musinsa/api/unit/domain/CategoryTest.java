package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.WrongCategoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("카테고리 도메인 관련 기능")
class CategoryTest {

    @Test
    @DisplayName("한글 카테고리명으로 카테고리를 생성한다")
    void createCategoryFromKorean() {
        // when
        Category category = Category.fromString("상의");

        // then
        assertThat(category).isEqualTo(Category.TOP);
        assertThat(category.getKorean()).isEqualTo("상의");
    }

    @Test
    @DisplayName("잘못된 카테고리명으로 생성 시 예외가 발생한다")
    void throwExceptionForInvalidCategory() {
        // when & then
        assertThatThrownBy(() -> Category.fromString("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid category: invalid");
    }

    @Test
    @DisplayName("null 카테고리명으로 생성 시 예외가 발생한다")
    void throwExceptionForNullCategory() {
        // when & then
        assertThatThrownBy(() -> Category.fromString(null))
                .isInstanceOf(WrongCategoryException.class)
                .hasMessage("Category value cannot be null");
    }
}
