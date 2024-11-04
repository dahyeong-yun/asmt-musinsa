package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.Brand;

public interface BrandRetrieveUseCase {
    Brand retrieve(Long brandId);
}
