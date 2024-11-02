package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.request.BrandCreateRequest;
import com.musinsa.api.adaptor.in.web.response.BrandRetrieveResponse;
import com.musinsa.api.application.port.in.BrandCreateUseCase;
import com.musinsa.api.application.port.in.BrandDeleteUseCase;
import com.musinsa.api.application.port.in.BrandRetrieveUseCase;
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
    public ResponseEntity retrieve(@PathVariable(name = "brandId") Long brandId) {
        Brand brand = brandRetrieveUseCase.retrieve(brandId);
        BrandRetrieveResponse brandRetrieveResponse = BrandRetrieveResponse.of(brand);
        return ResponseEntity
                .ok()
                .body(brandRetrieveResponse);
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity delete(@PathVariable(name = "brandId") Long brandId) {
        brandDeleteUseCase.delete(brandId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("/{brandId}")
    public ResponseEntity modify(@PathVariable(name = "brandId") Long brandId) {
        return ResponseEntity
                .ok()
                .build();
    }
}
