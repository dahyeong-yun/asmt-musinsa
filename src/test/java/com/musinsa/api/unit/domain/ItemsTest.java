package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("카테고리 상품 리스트 도메인 관련 기능")
class ItemsTest {

    private Items items;

    @BeforeEach
    void setUp() {
        // 카테고리 상품 데이터 초기화
        List<Item> itemList = new ArrayList<>();

        Brand nike = Brand.create("나이키");

        itemList.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(100_000))
                )
        );

        itemList.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(80_000))
                )
        );

        itemList.add(
                Item.create(nike,
                        Category.TOP,
                        ItemPrice.create(BigDecimal.valueOf(90_000))
                )
        );

        items = Items.create(itemList);
    }

    @Test
    @DisplayName("카테고리 최저가 상품 조회")
    void findLowestPriceItem() {
        Item lowestPriceItem = items.findLowestPriceItem();
        assertThat(lowestPriceItem.getItemPrice()).isEqualTo("80000");
    }

    @Test
    @DisplayName("카테고리 최고가 상품 조회")
    void findHighestPriceItem() {
        Item highestPriceItem = items.findHighestPriceItem();
        assertThat(highestPriceItem.getItemPrice()).isEqualTo("100000");
    }
}
