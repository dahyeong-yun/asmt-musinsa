package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.InvalidPriceException;
import com.musinsa.api.domain.ItemPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("0원은 유효한 가격이다")
    void createZeroPrice() {
        // given & when
        ItemPrice price = ItemPrice.create(BigDecimal.ZERO);

        // then
        assertThat(price.getPrice()).isEqualTo(BigDecimal.ZERO);
    }


    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "-999999.99"})
    @DisplayName("음수 가격은 생성할 수 없다")
    void createNegativePrice(String negativePrice) {
        assertThatThrownBy(() -> ItemPrice.create(new BigDecimal(negativePrice)))
                .isInstanceOf(InvalidPriceException.class)
                .hasMessage("상품 가격은 0원 이상이어야 합니다.");
    }
}
