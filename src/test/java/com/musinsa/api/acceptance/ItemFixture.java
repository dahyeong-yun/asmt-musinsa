package com.musinsa.api.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class ItemFixture {
    static ExtractableResponse<Response> 상품_생성_요청(String brandId, String categoryName, String price) {
        HashMap<String, String> params = new HashMap<>();
        params.put("brandId", brandId);
        params.put("categoryName", categoryName);
        params.put("price", price);

        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/api/v1/items")
                .then().log().all()
                .extract();
    }

    static ExtractableResponse<Response> 상품_조회_요청(Long itemId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/v1/items/" + itemId)
                .then().log().all()
                .extract();
    }


}
