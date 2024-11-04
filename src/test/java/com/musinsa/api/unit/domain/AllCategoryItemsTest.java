package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("전체 카테고리 상품 도메인 테스트")
class AllCategoryItemsTest {

    @Test
    @DisplayName("브랜드의 전체 카테고리 상품 총 가격을 계산한다")
    void calculateTotalPrice() {
        // given
        Brand nike = Brand.create("나이키");
        List<Item> itemList = Arrays.asList(
                Item.create(nike, Category.TOP, ItemPrice.create(BigDecimal.valueOf(10000))),
                Item.create(nike, Category.PANTS, ItemPrice.create(BigDecimal.valueOf(20000))),
                Item.create(nike, Category.SNEAKERS, ItemPrice.create(BigDecimal.valueOf(30000)))
        );

        // when
        AllCategoryItems allCategoryItems = AllCategoryItems.of(nike, itemList);

        // then
        assertThat(allCategoryItems.getBrandName()).isEqualTo("나이키");
        assertThat(allCategoryItems.getTotalPrice()).isEqualTo("60,000");
    }
}
