package com.musinsa.api.application.port.in;

import com.musinsa.api.adaptor.in.web.request.BrandCreateRequest;
import com.musinsa.api.domain.Brand;

public interface BrandCreateUseCase {
    Brand create(BrandCreateRequest request);
}
