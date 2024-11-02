package com.musinsa.api.acceptance;

import com.musinsa.api.config.AbstractAcceptanceTest;
import com.musinsa.api.domain.Category;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static com.musinsa.api.acceptance.PriceAnalysisFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

// 초기화 -> 테스트 격리
@DisplayName("가격 조회 관련 기능")
public class PriceAnalysisAcceptanceTest extends AbstractAcceptanceTest {

    @BeforeEach
    void setUp() {

    }

    /**
     * Given 브랜드가 1개 이상 등록되어 있고,
     * And 브랜드 별로 모든 카테고리의 상품이 1개 이상 등록되어 있을 때
     * When 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하면
     * Then 조회할 수 있다.
     */
    @Test
    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가 상품의 카테고리 및 가격, 총액을 조회할 수 있다.")
    void findLowestBrandPrices() {
        // given
        // TODO 브랜드 등록
        // TODO 카테고리별 상품 등록

        // when
        ExtractableResponse<Response> 최저가_조합_브랜드_조회_응답 = 최저가_조합_브랜드_조회_요청();
        String brandName = 최저가_조합_브랜드_조회_응답.body().jsonPath().getString("brandName");
        String totalPrice = 최저가_조합_브랜드_조회_응답.body().jsonPath().getString("totalPrice");
        List<Map<String, String>> categories = 최저가_조합_브랜드_조회_응답.body().jsonPath().getList("categories");

        // then
        assertThat(최저가_조합_브랜드_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(brandName).isEqualTo("테스트");
        assertThat(totalPrice).isEqualTo("110,000");

        assertThat(categories.get(0)).containsEntry("categoryName", Category.TOP.getKorean());
        assertThat(categories.get(1)).containsEntry("categoryName", Category.OUTER.getKorean());
        assertThat(categories.get(2)).containsEntry("categoryName", Category.PANTS.getKorean());
        assertThat(categories.get(3)).containsEntry("categoryName", Category.SNEAKERS.getKorean());
        assertThat(categories.get(4)).containsEntry("categoryName", Category.BAG.getKorean());
        assertThat(categories.get(5)).containsEntry("categoryName", Category.CAP.getKorean());
        assertThat(categories.get(6)).containsEntry("categoryName", Category.SOCKS.getKorean());
        assertThat(categories.get(7)).containsEntry("categoryName", Category.ACCESSORY.getKorean());
    }

    /**
     * Given 브랜드가 1개 이상 등록되어 있고,
     * And 브랜드 별로 모든 카테고리의 상품이 1개 이상 등록되어 있을 때
     * When 각 카테고리 별 최저가 상품을 조회하면
     * Then 조회할 수 있다.
     */
    @Test
    @DisplayName("특정 카테고리의 최저가 및 최고가 상품을 조회할 수 있다.")
    void findLowestPricesBrandMix() {
        // given
        // TODO 브랜드 등록
        // TODO 카테고리별 상품 등록

        // when
        ExtractableResponse<Response> 최저가_조합_브랜드_조회_응답 = 최저가_브랜드_조합_조회_요청();
        String totalPrice = 최저가_조합_브랜드_조회_응답.body().jsonPath().getString("totalPrice");
        List<Map<String, String>> categories = 최저가_조합_브랜드_조회_응답.body().jsonPath().getList("categories");

        // then
        assertThat(최저가_조합_브랜드_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(totalPrice).isEqualTo("34,100");
        assertThat(categories.get(0)).containsEntry("categoryName", Category.TOP.getKorean());
        assertThat(categories.get(1)).containsEntry("categoryName", Category.OUTER.getKorean());
        assertThat(categories.get(2)).containsEntry("categoryName", Category.PANTS.getKorean());
        assertThat(categories.get(3)).containsEntry("categoryName", Category.SNEAKERS.getKorean());
        assertThat(categories.get(4)).containsEntry("categoryName", Category.BAG.getKorean());
        assertThat(categories.get(5)).containsEntry("categoryName", Category.CAP.getKorean());
        assertThat(categories.get(6)).containsEntry("categoryName", Category.SOCKS.getKorean());
        assertThat(categories.get(7)).containsEntry("categoryName", Category.ACCESSORY.getKorean());

        assertThat(categories.get(0)).containsEntry("brandName", "C");
        assertThat(categories.get(1)).containsEntry("brandName", "E");
        assertThat(categories.get(2)).containsEntry("brandName", "D");
        assertThat(categories.get(3)).containsEntry("brandName", "G");
        assertThat(categories.get(4)).containsEntry("brandName", "A");
        assertThat(categories.get(5)).containsEntry("brandName", "D");
        assertThat(categories.get(6)).containsEntry("brandName", "I");
        assertThat(categories.get(7)).containsEntry("brandName", "F");

        assertThat(categories.get(0)).containsEntry("price", "10,000");
        assertThat(categories.get(1)).containsEntry("price", "5,000");
        assertThat(categories.get(2)).containsEntry("price", "3,000");
        assertThat(categories.get(3)).containsEntry("price", "9,000");
        assertThat(categories.get(4)).containsEntry("price", "2,000");
        assertThat(categories.get(5)).containsEntry("price", "1,500");
        assertThat(categories.get(6)).containsEntry("price", "1,700");
        assertThat(categories.get(7)).containsEntry("price", "1,900");
    }

    /**
     * Given 브랜드가 1개 이상 등록되어 있고,
     * And 브랜드 별로 모든 카테고리의 상품이 1개 이상 등록되어 있을 때
     * When 특정 카테고리의 최저가 및 최고가 상품을 조회하면
     * Then 조회할 수 있다.
     */
    @Test
    @DisplayName("특정 카테고리의 최저가 및 최고가 상품을 조회할 수 있다.")
    void findLowestAndHighestBrandPrices() {
        // when
        ExtractableResponse<Response> 카테고리별_최고가_및_최저가_브랜드_조회_응답 = 카테고리별_최고가_및_최저가_브랜드_조회_요청(Category.TOP.getKorean());

        카테고리별_최고가_및_최저가_브랜드_조회_응답.body().jsonPath().getString("categoryName");

        List<Map<String, String>> lowestPrice = 카테고리별_최고가_및_최저가_브랜드_조회_응답.body().jsonPath().getList("lowestPrice");
        List<Map<String, String>> highestPrice = 카테고리별_최고가_및_최저가_브랜드_조회_응답.body().jsonPath().getList("highestPrice");

        assertThat(lowestPrice.get(0)).containsEntry("brandName", "C");
        assertThat(lowestPrice.get(0)).containsEntry("price","10,000");

        assertThat(highestPrice.get(0)).containsEntry("brandName", "I");
        assertThat(highestPrice.get(0)).containsEntry("price", "11,400");
    }
}
