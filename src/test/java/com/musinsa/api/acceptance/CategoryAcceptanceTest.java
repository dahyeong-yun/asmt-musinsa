package com.musinsa.api.acceptance;

import com.musinsa.api.domain.Category;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// 초기화 -> 테스트 격리
@DisplayName("카테고리 관련 기능")
public class CategoryAcceptanceTest {

    /**
     * Given 브랜드가 1개 이상 등록되어 있고,
     * And 브랜드 별로 모든 카테고리의 상품이 1개 이상 등록되어 있을 때
     * When 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하면
     * Then 조회할 수 있다.
     */
    @Test
    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회할 수 있다.")
    void findLowestBrandPrices() {
        // when
        ExtractableResponse<Response> 최저가_조합_브랜드_조회_응답 = 최저가_조합_브랜드_조회_요청();
        String brandName = 최저가_조합_브랜드_조회_응답.body().jsonPath().getString("brandName");
        String totalPrice = 최저가_조합_브랜드_조회_응답.body().jsonPath().getString("totalPrice");
        List<Map<String, String>> categories = 최저가_조합_브랜드_조회_응답.body().jsonPath().getList("categories");

        // then
        assertThat(최저가_조합_브랜드_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(brandName).isEqualTo("테스트");
        assertThat(totalPrice).isEqualTo("10000");
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
     * When 특정 카테고리의 최저가 및 최고가 상품을 조회하면
     * Then 조회할 수 있다.
     */
    void findLowestAndHighestBrandPrices() {
        // when
    }

    private ExtractableResponse<Response> 최저가_조합_브랜드_조회_요청() {
        return RestAssured.given().log().all()
                .when().get("/api/v1/price-analysis/brands/lowest-prices")
                .then().log().all()
                .extract();
    }

    private ExtractableResponse<Response> 최저가_브랜드_조합_조회_요청() {
        return RestAssured.given().log().all()
                .when().get("/api/v1/price-analysis/brands/lowest-prices-combination")
                .then().log().all()
                .extract();
    }

    private ExtractableResponse<Response> 카테고리별_최고가_및_최저가_브랜드_조회_요청(String categoryName) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/v1/price-analysis/" + categoryName + "/lowest-highest-prices")
                .then().log().all()
                .extract();
    }
}
