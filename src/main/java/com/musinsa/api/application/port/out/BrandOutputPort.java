package com.musinsa.api.application.port.out;

import com.musinsa.api.domain.Brand;

import java.util.Optional;

public interface BrandOutputPort {
    Brand save(Brand brand);

    Optional<Brand> findById(Long brandId);

    void deleteById(Long brandId);
}
