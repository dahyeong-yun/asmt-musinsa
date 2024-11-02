package com.musinsa.api.acceptance;

import com.musinsa.api.config.AbstractAcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.musinsa.api.acceptance.BrandFixture.브랜드_생성_요청;
import static com.musinsa.api.acceptance.BrandFixture.브랜드_조회_요청;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("브랜드 관련 기능")
public class BrandAcceptanceTest extends AbstractAcceptanceTest {

    String brandCreateRequestName = "나이키";

    /**
     * Given 브랜드 이름이 주어지고,
     * When 중복되지 않은 사업자 번호로 등록 요청하면
     * Then 브랜드가 등록된다.
     */
    @Test
    @DisplayName("브랜드 명과 사업자 번호를 가지고 브랜드를 등록할 수 있다.")
    void createBrand() {
        // when
        ExtractableResponse<Response> 브랜드_생성_응답 = 브랜드_생성();

        // then
        Long brandId = 브랜드_생성_응답.body().jsonPath().getLong("id");

        assertThat(브랜드_생성_응답.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(brandId).isNotNull();
    }

    /**
     * Given 브랜드가 생성되어 있고,
     * When 브랜드 아이디로 브랜드를 조회하면
     * Then 브랜드가 조회된다.
     */
    @Test
    @DisplayName("브랜드 아이디를 가지고 특정 브랜드를 조회할 수 있다.")
    void retrieveBrand() {
        // given
        ExtractableResponse<Response> 브랜드_생성_응답 = 브랜드_생성();
        Long brandId = 브랜드_생성_응답.body().jsonPath().getLong("id");

        // when
        ExtractableResponse<Response> 브랜드_조회_응답 = 브랜드_조회_요청(brandId);

        // then
        String brandName = 브랜드_생성_응답.body().jsonPath().getString("brandName");
        String businessNumber = 브랜드_생성_응답.body().jsonPath().getString("businessNumber");

        assertThat(브랜드_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(brandName).isEqualTo(brandCreateRequestName);
    }

    private ExtractableResponse<Response> 브랜드_생성() {
        ExtractableResponse<Response> 브랜드_생성_응답 = 브랜드_생성_요청(brandCreateRequestName);
        return 브랜드_생성_응답;
    }

    /**
     * Given 브랜드가 생성되어 있고,
     * When 브랜드 아이디로 브랜드를 삭제하면
     * Then 브랜드가 삭제된다.
//     */
//    @Test
//    @DisplayName("브랜드 아이디를 가지고 브랜드를 삭제할 수 있다.")

    /**
     * Given 브랜드가 생성되어 있고,
     * When 브랜드 아이디로 브랜드를 삭제할 때
     * And 브랜드에 등록된 상품이 있으면
     * Then 브랜드 삭제에 실패한다.
     */
//    @Test
//    @DisplayName("브랜드 매핑 상품이 존재하는 경우 브랜드를 삭제할 수 없다.")


    /**
     * Given 브랜드가 생성되어 있고,
     * When 브랜드 아이디와 변경할 브랜드 명을 가지고 브랜드를 수정하면
     * Then 브랜드 명이 변경된다.
     */
//    @DisplayName("브랜드 아이디와 수정할 필드 값을 가지고 브랜드를 수정할 수 있다.") : 사업자번호 수정 불가


    /**
     * Given 브랜드가 생성되어 있고,
     * When 브랜드 아이디와 변경할 브랜드 명을 가지고 브랜드를 수정할 때
     * And 브랜드 명이 중복되면
     * Then 브랜드 명이 변경되지 않는다.
     */
}
