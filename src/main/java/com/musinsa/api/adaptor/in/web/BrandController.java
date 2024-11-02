package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.request.BrandCreateRequest;
import com.musinsa.api.adaptor.in.web.response.BrandRetrieveResponse;
import com.musinsa.api.application.port.in.BrandCreateUseCase;
import com.musinsa.api.application.port.in.BrandDeleteUseCase;
import com.musinsa.api.application.port.in.BrandRetrieveUseCase;
import com.musinsa.api.application.port.in.LowestCategoryPricesUseCase;
import com.musinsa.api.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
@RestController
public class BrandController {
    private final BrandCreateUseCase brandCreateUseCase;
    private final BrandRetrieveUseCase brandRetrieveUseCase;
    private final BrandDeleteUseCase brandDeleteUseCase;
    private final LowestCategoryPricesUseCase lowestCategoryPricesUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody BrandCreateRequest request, BindingResult bindingResult) {
        // TODO request validation
        // TODO request to command
        Brand brand = brandCreateUseCase.create(request);
        // TODO domain to response
        return ResponseEntity
                .created(URI.create("/api/v1/brand" + brand.getId()))
                .body(brand);
    }

    @GetMapping
    public ResponseEntity retrieveAll() {
        var brands = brandRetrieveUseCase.retrieveAll();
        return ResponseEntity
                .ok()
                .body(brands);
    }

    @GetMapping("/{brandId}")
    public ResponseEntity retrieve(@PathVariable Long brandId) {
        Brand brand = brandRetrieveUseCase.retrieve(brandId);
        BrandRetrieveResponse brandRetrieveResponse = BrandRetrieveResponse.of(brand);
        return ResponseEntity
                .ok()
                .body(brandRetrieveResponse);
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity delete(@PathVariable Long brandId) {
        brandDeleteUseCase.delete(brandId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("/{brandId}")
    public ResponseEntity modify(@PathVariable Long brandId) {
        return ResponseEntity
                .ok()
                .build();
    }

// TODO 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
    @GetMapping("/{brandId}/lowest-category-prices")
    public ResponseEntity retrieveCody(@PathVariable Long brandId) {
        lowestCategoryPricesUseCase.findLowestPricesItemsByBrand(brandId);
        return ResponseEntity
                .ok()
                .build();
    }
}
