package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.ItemPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상품 도메인 테스트")
class ItemTest {

    @Test
    @DisplayName("상품을 생성한다")
    void createItem() {
        // given
        Brand brand = Brand.create("나이키");
        Category category = Category.TOP;
        ItemPrice price = ItemPrice.create(BigDecimal.valueOf(10000));

        // when
        Item item = Item.create(brand, category, price);

        // then
        assertThat(item.getItemBrandName()).isEqualTo("나이키");
        assertThat(item.getItemCategoryName()).isEqualTo("상의");
        assertThat(item.getItemPrice()).isEqualTo(BigDecimal.valueOf(10000));
        assertThat(item.getItemFormattedPrice()).isEqualTo("10,000");
    }
}
