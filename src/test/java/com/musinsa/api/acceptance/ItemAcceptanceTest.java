package com.musinsa.api.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상품 관련 기능")
public class ItemAcceptanceTest {

    /**
     * Given 브랜드가 등록 되어 있고
     * And 카테고리 정보가 올바를 때,
     * And 상품 정보를 가지고 등록 요청을 하면
     * Then 상품이 등록된다.
     */
    @Test
    @DisplayName("상품 가격과 브랜드, 카테고리를 가지고 상품을 등록할 수 있다.")
    void createFavorite() {
        // when
        ExtractableResponse<Response> 상품_생성_응답 = 상품_생성_요청();

        // then
        assertThat(상품_생성_응답.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> 상품_생성_요청() {
        HashMap<String, String> params = new HashMap<>();
        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/api/v1/brand")
                .then().log().all()
                .extract();
    }

}
