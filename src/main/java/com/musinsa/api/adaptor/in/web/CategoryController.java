package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.response.AllCategoryResponse;
import com.musinsa.api.adaptor.in.web.response.CategoryResponse;
import com.musinsa.api.application.port.in.LowestCategoryPricesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {

    private final LowestCategoryPricesUseCase lowestCategoryPricesUseCase;

    @GetMapping("/lowest-prices-brand")
    public ResponseEntity lowestBrandPrices() {
        var items = lowestCategoryPricesUseCase.findLowestPricesItemsByBrand();
        var response = AllCategoryResponse.of(items);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping("/{categoryName}/lowest-and-highest-prices-brand")
    public ResponseEntity lowestAndHighestBrandPrices(@PathVariable String categoryName) {
        var response = CategoryResponse.toResponse(categoryName); // TODO usecase.findLowestAndHighestBrandPricesByCategory(categoryName);
        return ResponseEntity
                .ok()
                .body(response);
    }
}
