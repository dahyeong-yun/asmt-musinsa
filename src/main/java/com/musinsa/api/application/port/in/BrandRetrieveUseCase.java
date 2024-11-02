package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.Brand;

import java.util.List;

public interface BrandRetrieveUseCase {
    List<Brand> retrieveAll();

    Brand retrieve(Long brandId);
}
