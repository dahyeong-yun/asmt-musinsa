package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.response.BrandPrice;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {


    @GetMapping("/lowest-price")
    public ResponseEntity retrieveAll() {
        return ResponseEntity
                .ok()
                .body(CategoryResponse.builder()
                        .categoryName("상의")
                        .lowestPrice(List.of(BrandPrice.builder().brand("C").price("10,000").build()))
                        .highestPrice(List.of(BrandPrice.builder().brand("I").price("11,400").build()))
                        .build());
    }

    @Builder
    static class CategoryResponse {
        private String categoryName;
        private List<BrandPrice> lowestPrice;
        private List<BrandPrice> highestPrice;
    }

    // 카테고리 이름으로 최저, 최고 가격 브랜드를 조회
/*
    {
        "카테고리" : "상의",
            "최저가" : [
                   {"브랜드" : "C", "가격" : "10,000"}
               ],
            "최고가" : [
                    {"브랜드" : "I", "가격" : "11,400"}
             ]
    }
*/
}
