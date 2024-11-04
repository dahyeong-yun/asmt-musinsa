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

import static com.musinsa.api.acceptance.BrandFixture.브랜드_생성_요청;
import static com.musinsa.api.acceptance.ItemFixture.상품_생성_요청;
import static com.musinsa.api.acceptance.PriceAnalysisFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

// 초기화 -> 테스트 격리
@DisplayName("가격 조회 관련 기능")
public class PriceAnalysisAcceptanceTest extends AbstractAcceptanceTest {

    private void 샘플_데이터_생성() {
        // 브랜드 생성
        ExtractableResponse<Response> 브랜드_A = 브랜드_생성_요청("A");
        ExtractableResponse<Response> 브랜드_B = 브랜드_생성_요청("B");
        ExtractableResponse<Response> 브랜드_C = 브랜드_생성_요청("C");
        ExtractableResponse<Response> 브랜드_D = 브랜드_생성_요청("D");
        ExtractableResponse<Response> 브랜드_E = 브랜드_생성_요청("E");
        ExtractableResponse<Response> 브랜드_F = 브랜드_생성_요청("F");
        ExtractableResponse<Response> 브랜드_G = 브랜드_생성_요청("G");
        ExtractableResponse<Response> 브랜드_H = 브랜드_생성_요청("H");
        ExtractableResponse<Response> 브랜드_I = 브랜드_생성_요청("I");

        String 브랜드_A_ID = 브랜드_A.body().jsonPath().getString("id");
        String 브랜드_B_ID = 브랜드_B.body().jsonPath().getString("id");
        String 브랜드_C_ID = 브랜드_C.body().jsonPath().getString("id");
        String 브랜드_D_ID = 브랜드_D.body().jsonPath().getString("id");
        String 브랜드_E_ID = 브랜드_E.body().jsonPath().getString("id");
        String 브랜드_F_ID = 브랜드_F.body().jsonPath().getString("id");
        String 브랜드_G_ID = 브랜드_G.body().jsonPath().getString("id");
        String 브랜드_H_ID = 브랜드_H.body().jsonPath().getString("id");
        String 브랜드_I_ID = 브랜드_I.body().jsonPath().getString("id");

        // A 브랜드 상품 생성
        상품_생성_요청(브랜드_A_ID, Category.TOP.getKorean(), "11200");
        상품_생성_요청(브랜드_A_ID, Category.OUTER.getKorean(), "5500");
        상품_생성_요청(브랜드_A_ID, Category.PANTS.getKorean(), "4200");
        상품_생성_요청(브랜드_A_ID, Category.SNEAKERS.getKorean(), "9000");
        상품_생성_요청(브랜드_A_ID, Category.BAG.getKorean(), "2000");
        상품_생성_요청(브랜드_A_ID, Category.CAP.getKorean(), "1700");
        상품_생성_요청(브랜드_A_ID, Category.SOCKS.getKorean(), "1800");
        상품_생성_요청(브랜드_A_ID, Category.ACCESSORY.getKorean(), "2300");

        // B 브랜드 상품 생성
        상품_생성_요청(브랜드_B_ID, Category.TOP.getKorean(), "10500");
        상품_생성_요청(브랜드_B_ID, Category.OUTER.getKorean(), "5900");
        상품_생성_요청(브랜드_B_ID, Category.PANTS.getKorean(), "3800");
        상품_생성_요청(브랜드_B_ID, Category.SNEAKERS.getKorean(), "9100");
        상품_생성_요청(브랜드_B_ID, Category.BAG.getKorean(), "2100");
        상품_생성_요청(브랜드_B_ID, Category.CAP.getKorean(), "2000");
        상품_생성_요청(브랜드_B_ID, Category.SOCKS.getKorean(), "2000");
        상품_생성_요청(브랜드_B_ID, Category.ACCESSORY.getKorean(), "2200");

        // C 브랜드 상품 생성
        상품_생성_요청(브랜드_C_ID, Category.TOP.getKorean(), "10000");
        상품_생성_요청(브랜드_C_ID, Category.OUTER.getKorean(), "6200");
        상품_생성_요청(브랜드_C_ID, Category.PANTS.getKorean(), "3300");
        상품_생성_요청(브랜드_C_ID, Category.SNEAKERS.getKorean(), "9200");
        상품_생성_요청(브랜드_C_ID, Category.BAG.getKorean(), "2200");
        상품_생성_요청(브랜드_C_ID, Category.CAP.getKorean(), "1900");
        상품_생성_요청(브랜드_C_ID, Category.SOCKS.getKorean(), "2200");
        상품_생성_요청(브랜드_C_ID, Category.ACCESSORY.getKorean(), "2100");

        // D 브랜드 상품 생성
        상품_생성_요청(브랜드_D_ID, Category.TOP.getKorean(), "10100");
        상품_생성_요청(브랜드_D_ID, Category.OUTER.getKorean(), "5100");
        상품_생성_요청(브랜드_D_ID, Category.PANTS.getKorean(), "3000");
        상품_생성_요청(브랜드_D_ID, Category.SNEAKERS.getKorean(), "9500");
        상품_생성_요청(브랜드_D_ID, Category.BAG.getKorean(), "2500");
        상품_생성_요청(브랜드_D_ID, Category.CAP.getKorean(), "1500");
        상품_생성_요청(브랜드_D_ID, Category.SOCKS.getKorean(), "2400");
        상품_생성_요청(브랜드_D_ID, Category.ACCESSORY.getKorean(), "2000");

        // E 브랜드 상품 생성
        상품_생성_요청(브랜드_E_ID, Category.TOP.getKorean(), "10700");
        상품_생성_요청(브랜드_E_ID, Category.OUTER.getKorean(), "5000");
        상품_생성_요청(브랜드_E_ID, Category.PANTS.getKorean(), "3800");
        상품_생성_요청(브랜드_E_ID, Category.SNEAKERS.getKorean(), "9900");
        상품_생성_요청(브랜드_E_ID, Category.BAG.getKorean(), "2300");
        상품_생성_요청(브랜드_E_ID, Category.CAP.getKorean(), "1800");
        상품_생성_요청(브랜드_E_ID, Category.SOCKS.getKorean(), "2100");
        상품_생성_요청(브랜드_E_ID, Category.ACCESSORY.getKorean(), "2100");

        // F 브랜드 상품 생성
        상품_생성_요청(브랜드_F_ID, Category.TOP.getKorean(), "11200");
        상품_생성_요청(브랜드_F_ID, Category.OUTER.getKorean(), "7200");
        상품_생성_요청(브랜드_F_ID, Category.PANTS.getKorean(), "4000");
        상품_생성_요청(브랜드_F_ID, Category.SNEAKERS.getKorean(), "9300");
        상품_생성_요청(브랜드_F_ID, Category.BAG.getKorean(), "2100");
        상품_생성_요청(브랜드_F_ID, Category.CAP.getKorean(), "1600");
        상품_생성_요청(브랜드_F_ID, Category.SOCKS.getKorean(), "2300");
        상품_생성_요청(브랜드_F_ID, Category.ACCESSORY.getKorean(), "1900");

        // G 브랜드 상품 생성
        상품_생성_요청(브랜드_G_ID, Category.TOP.getKorean(), "10500");
        상품_생성_요청(브랜드_G_ID, Category.OUTER.getKorean(), "5800");
        상품_생성_요청(브랜드_G_ID, Category.PANTS.getKorean(), "3900");
        상품_생성_요청(브랜드_G_ID, Category.SNEAKERS.getKorean(), "9000");
        상품_생성_요청(브랜드_G_ID, Category.BAG.getKorean(), "2200");
        상품_생성_요청(브랜드_G_ID, Category.CAP.getKorean(), "1700");
        상품_생성_요청(브랜드_G_ID, Category.SOCKS.getKorean(), "2100");
        상품_생성_요청(브랜드_G_ID, Category.ACCESSORY.getKorean(), "2000");

        // H 브랜드 상품 생성
        상품_생성_요청(브랜드_H_ID, Category.TOP.getKorean(), "10800");
        상품_생성_요청(브랜드_H_ID, Category.OUTER.getKorean(), "6300");
        상품_생성_요청(브랜드_H_ID, Category.PANTS.getKorean(), "3100");
        상품_생성_요청(브랜드_H_ID, Category.SNEAKERS.getKorean(), "9700");
        상품_생성_요청(브랜드_H_ID, Category.BAG.getKorean(), "2100");
        상품_생성_요청(브랜드_H_ID, Category.CAP.getKorean(), "1600");
        상품_생성_요청(브랜드_H_ID, Category.SOCKS.getKorean(), "2000");
        상품_생성_요청(브랜드_H_ID, Category.ACCESSORY.getKorean(), "2000");

        // I 브랜드 상품 생성
        상품_생성_요청(브랜드_I_ID, Category.TOP.getKorean(), "11400");
        상품_생성_요청(브랜드_I_ID, Category.OUTER.getKorean(), "6700");
        상품_생성_요청(브랜드_I_ID, Category.PANTS.getKorean(), "3200");
        상품_생성_요청(브랜드_I_ID, Category.SNEAKERS.getKorean(), "9500");
        상품_생성_요청(브랜드_I_ID, Category.BAG.getKorean(), "2400");
        상품_생성_요청(브랜드_I_ID, Category.CAP.getKorean(), "1700");
        상품_생성_요청(브랜드_I_ID, Category.SOCKS.getKorean(), "1700");
        상품_생성_요청(브랜드_I_ID, Category.ACCESSORY.getKorean(), "2400");
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
        샘플_데이터_생성();

        // when
        ExtractableResponse<Response> 최저가_조합_브랜드_상품_리스트_조회_응답 = 최저가_조합_브랜드_상품_리스트_조회_요청();
        String brandName = 최저가_조합_브랜드_상품_리스트_조회_응답.body().jsonPath().getString("brandName");
        String totalPrice = 최저가_조합_브랜드_상품_리스트_조회_응답.body().jsonPath().getString("totalPrice");
        List<Map<String, String>> categories = 최저가_조합_브랜드_상품_리스트_조회_응답.body().jsonPath().getList("categories");

        // then
        assertThat(최저가_조합_브랜드_상품_리스트_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(brandName).isEqualTo("D");
        assertThat(totalPrice).isEqualTo("36,100");

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
    @DisplayName("각 카테고리 별 최저가 상품을 조회할 수 있다.")
    void findLowestPricesBrandMix() {
        // given
        샘플_데이터_생성();

        // when
        ExtractableResponse<Response> 카테고리별_최저가_상풍_리스트_조합_조회_응답 = 카테고리별_최저가_상풍_리스트_조합_조회_요청();
        String totalPrice = 카테고리별_최저가_상풍_리스트_조합_조회_응답.body().jsonPath().getString("totalPrice");
        List<Map<String, String>> categories = 카테고리별_최저가_상풍_리스트_조합_조회_응답.body().jsonPath().getList("categories");

        // then
        assertThat(카테고리별_최저가_상풍_리스트_조합_조회_응답.statusCode()).isEqualTo(HttpStatus.OK.value());
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
        // given
        샘플_데이터_생성();

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
