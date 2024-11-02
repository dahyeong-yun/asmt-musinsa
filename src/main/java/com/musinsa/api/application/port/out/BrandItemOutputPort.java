package com.musinsa.api.application.port.out;

import com.musinsa.api.domain.Item;

import java.util.List;
import java.util.Optional;

public interface BrandItemOutputPort {
    Optional<List<Item>> findByBrandId(Long brandId);
}
