package com.musinsa.api.unit.domain;

import com.musinsa.api.domain.Brand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("브랜드 도메인 관련 기능")
class BrandTest {
    @Test
    @DisplayName("브랜드를 생성한다")
    void createBrand() {
        // when
        Brand brand = Brand.create("나이키");

        // then
        assertThat(brand.getBrandName()).isEqualTo("나이키");
    }

    @Test
    @DisplayName("브랜드명을 수정한다")
    void updateBrandName() {
        // given
        Brand brand = Brand.create("나이키");

        // when
        brand.updateBrandName("아디다스");

        // then
        assertThat(brand.getBrandName()).isEqualTo("아디다스");

    }
}
