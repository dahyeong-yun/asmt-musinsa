package com.musinsa.api.acceptance;

import com.musinsa.api.config.AbstractAcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.musinsa.api.acceptance.BrandFixture.브랜드_삭제_요청;
import static com.musinsa.api.acceptance.BrandFixture.브랜드_생성;
import static com.musinsa.api.acceptance.ItemFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상품 관련 기능")
public class ItemAcceptanceTest extends AbstractAcceptanceTest {

    /**
     * Given 브랜드가 등록 되어 있고
     * And 카테고리 정보가 올바를 때,
     * And 상품 정보를 가지고 등록 요청을 하면
     * Then 상품이 등록된다.
     */
    @Test
    @DisplayName("상품 가격과 브랜드, 카테고리를 가지고 상품을 등록할 수 있다.")
    void createItem() {
        // given
        ExtractableResponse<Response> 브랜드_생성_응답 = 브랜드_생성("나이키");
        Long brandId = 브랜드_생성_응답.body().jsonPath().getLong("id");

        // when
        ExtractableResponse<Response> 상품_생성_응답 = 상품_생성_요청(brandId.toString(), "상의", "10000");

        // then
        assertThat(상품_생성_응답.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    /**
     * Given 상품이 등록 되어 있고
     * When 상품 아이디로 상품을 조회하면
     * Then 상품이 조회된다.
     */
    @Test
    @DisplayName("상품 아이디를 가지고 특정 상품을 조회할 수 있다.")
    void retrieveItem() {
        // given
        Long itemId = 상품_생성();

        // when
        ExtractableResponse<Response> 상품_조회_응답 = 상품_조회_요청(itemId);

        // then
        String brandName = 상품_조회_응답.body().jsonPath().getString("brandName");
        String categoryName = 상품_조회_응답.body().jsonPath().getString("categoryName");
        String price = 상품_조회_응답.body().jsonPath().getString("price");

        assertThat(상품_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(brandName).isEqualTo("나이키");
        assertThat(categoryName).isEqualTo("상의");
        assertThat(price).isEqualTo("10,000");
    }

    /**
     * Given 상품이 등록 되어 있고
     * When 상품 아이디로 상품을 삭제하면
     * Then 상품이 삭제된다.
     */
    @Test
    @DisplayName("상품 아이디를 가지고 상품을 삭제할 수 있다.")
    void deleteItem() {
        // given
        Long itemId = 상품_생성();

        // when
        ExtractableResponse<Response> 상품_삭제_응답 = 상품_삭제_요청(itemId);

        // then
        assertThat(상품_삭제_응답.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }


    /**
     * Given 삼품이 등록되어 있지 않고,
     * When 존재하지 않는 브랜드 아이디로 브랜드를 삭제하면
     * Then 브랜드가 삭제되지 않는다.
     */
    @Test
    @DisplayName("존재하지 않는 상품을 삭제하는 경우 상품을 삭제할 수 없다.")
    void deleteItemWithNotExistItemId() {
        // given
        Long itemId = 1L;

        // when
        ExtractableResponse<Response> 상품_삭제_응답 = 상품_삭제_요청(itemId);

        // then
        assertThat(상품_삭제_응답.statusCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }




    /**
     * Given 상품이 등록되어 있고,
     * When 상품 아이디와 변경할 상품 가격을 가지고 상품 가격을 수정하면
     * Then 상품 가격이 변경된다.
     */
// 동일 브랜드로 수정 불가

    /**
     * Given 상품이 등록되어 있고,
     * When 상품 아이디와 변경할 카테고리를 가지고 상품 카테고리를 수정하면
     * Then 상품 카테고리가 변경된다.
     */
// 동일 카테고리로 수정 불가

    /**
     * Given 상품이 등록되어 있고,
     * When 상품 아이디와 변경할 상품 가격을 가지고 상품 가격을 수정하면
     * Then 상품 가격이 변경된다.
     */
// 동일 가격으로 수정 불가


    private static Long 상품_생성() {
        ExtractableResponse<Response> 브랜드_생성_응답 = 브랜드_생성("나이키");
        Long brandId = 브랜드_생성_응답.body().jsonPath().getLong("id");
        ExtractableResponse<Response> 상품_생성_응답 = 상품_생성_요청(brandId.toString(), "상의", "10000");
        Long itemId = 상품_생성_응답.body().jsonPath().getLong("id");
        return itemId;
    }
}
