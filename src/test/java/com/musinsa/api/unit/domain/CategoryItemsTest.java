package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("카테고리 상품 리스트 도메인 관련 기능")
class CategoryItemsTest {

    private CategoryItems categoryItems;

    @BeforeEach
    void setUp() {
        // 카테고리 상품 데이터 초기화
        categoryItems = new CategoryItems();

        Brand nike = Brand.create("나이키", "12123123");

        categoryItems.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(100_000))
                )
        );

        categoryItems.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(80_000))
                )
        );

        categoryItems.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(90_000))
                )
        );
    }

    @Test
    @DisplayName("카테고리 최저가 상품 조회")
    void findLowestPriceItem() {
        Item lowestPriceItem = categoryItems.findLowestPriceItem();
        assertThat(lowestPriceItem.getPrice().getPrice()).isEqualTo(BigDecimal.valueOf(80_000));
    }


    @Test
    @DisplayName("카테고리 최고가 상품 조회")
    void findHighestPriceItem() {
        Item highestPriceItem = categoryItems.findHighestPriceItem();
        assertThat(highestPriceItem.getPrice().getPrice()).isEqualTo(BigDecimal.valueOf(100_000));
    }

    // e2e 테스트
    // 사용자는 카테고리 상품 중 최저가를 조회할 수 있다.
    // 사용자는 카테고리 상품 중 최고가를 조회할 수 있다.
}
