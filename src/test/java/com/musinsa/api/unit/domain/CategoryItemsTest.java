package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("카테고리별 최저가/최고가 상품 도메인 테스트")
class CategoryItemsTest {

    @Test
    @DisplayName("카테고리별 최저가와 최고가 상품을 조회한다")
    void findLowestAndHighestPriceItems() {
        // given
        Brand nike = Brand.create("나이키");
        List<Item> itemList = Arrays.asList(
                Item.create(nike, Category.TOP, ItemPrice.create(BigDecimal.valueOf(10000))),
                Item.create(nike, Category.TOP, ItemPrice.create(BigDecimal.valueOf(20000))),
                Item.create(nike, Category.TOP, ItemPrice.create(BigDecimal.valueOf(30000)))
        );
        Items items = Items.create(itemList);
        CategoryItems categoryItems = CategoryItems.of(Category.TOP, items);

        // when & then
        assertThat(categoryItems.getCategoryName()).isEqualTo("상의");
        assertThat(categoryItems.getLowestPriceItem().getItemPrice())
                .isEqualTo(BigDecimal.valueOf(10000));
        assertThat(categoryItems.getHighestPriceItem().getItemPrice())
                .isEqualTo(BigDecimal.valueOf(30000));
    }
}
