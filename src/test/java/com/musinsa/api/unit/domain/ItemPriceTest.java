package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.ItemPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상품 가격 도메인 테스트")
class ItemPriceTest {

    @Test
    @DisplayName("가격을 생성하고 포맷팅된 문자열로 변환한다")
    void createAndFormatPrice() {
        // given
        ItemPrice price = ItemPrice.create(BigDecimal.valueOf(1234567));

        // when
        String formattedPrice = price.toFormattedString();

        // then
        assertThat(formattedPrice).isEqualTo("1,234,567");
    }

    @Test
    @DisplayName("null 가격은 0으로 포맷팅된다")
    void formatNullPrice() {
        // given
        ItemPrice price = ItemPrice.create(null);

        // when
        String formattedPrice = price.toFormattedString();

        // then
        assertThat(formattedPrice).isEqualTo("0");
    }
}
