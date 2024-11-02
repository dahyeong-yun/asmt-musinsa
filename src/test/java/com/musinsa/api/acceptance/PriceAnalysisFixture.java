package com.musinsa.api.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class PriceAnalysisFixture {
    static ExtractableResponse<Response> 최저가_조합_브랜드_조회_요청() {
        return RestAssured.given().log().all()
                .when().get("/api/v1/price-analysis/brands/lowest-prices")
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 최저가_브랜드_조합_조회_요청() {
        return RestAssured.given().log().all()
                .when().get("/api/v1/price-analysis/brands/lowest-prices-combination")
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 카테고리별_최고가_및_최저가_브랜드_조회_요청(String categoryName) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/v1/price-analysis/categories/" + categoryName + "/lowest-highest-prices")
                .then().log().all()
                .extract();
    }
}
