package com.musinsa.api.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class BrandFixture {
     static ExtractableResponse<Response> 브랜드_생성_요청(String brandName, String businessNumber) {
        HashMap<String, String> params = new HashMap<>();
        params.put("brandName", brandName);
        params.put("businessNumber", businessNumber);

        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/api/v1/brand")
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 브랜드_전체_조회_요청(String bradnName, String businessNumber) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/v1/brand")
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 브랜드_조회_요청(Long brandId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/v1/brand/" + brandId)
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 브랜드_삭제_요청(Long brandId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().delete("/api/v1/brand/" + brandId)
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 브랜드_수정_요청(Long brandId, String brandName) {
        HashMap<String, String> params = new HashMap<>();
        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().put("/api/v1/brand/" + brandId)
                .then().log().all()
                .extract();
    }
}
