package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.response.LowestPricesBrandMixResponse;
import com.musinsa.api.adaptor.in.web.response.LowestPricesOneBrandResponse;
import com.musinsa.api.adaptor.in.web.response.CategoryResponse;
import com.musinsa.api.application.port.in.PricesRetrieveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/price-analysis")
@RestController
public class PriceAnalysisController {

    private final PricesRetrieveUseCase pricesRetrieveUseCase;

    @GetMapping("/brands/lowest-prices")
    public ResponseEntity lowestPricesOneBrand() {
        var items = pricesRetrieveUseCase.findLowestPriceCategorySetPerBrand();
        var response = LowestPricesOneBrandResponse.of(items);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping("/brands/lowest-prices-combination")
    public ResponseEntity lowestPricesBrandMix() {
        var items = pricesRetrieveUseCase.findLowestPriceCategorySetAcrossBrands();
        var response = LowestPricesBrandMixResponse.of(items);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping("/categories/{categoryName}/lowest-highest-prices")
    public ResponseEntity lowestAndHighestBrandPrices(@PathVariable(name = "categoryName") String categoryName) {
        var categoryItems = pricesRetrieveUseCase.findLowestAndHighestPricesAtCategory(categoryName);
        var response = CategoryResponse.of(categoryItems); // TODO usecase.findLowestAndHighestBrandPricesByCategory(categoryName);
        return ResponseEntity
                .ok()
                .body(response);
    }
}
