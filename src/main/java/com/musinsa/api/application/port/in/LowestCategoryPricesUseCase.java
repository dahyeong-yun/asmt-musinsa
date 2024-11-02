package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.Item;

import java.util.List;

public interface LowestCategoryPricesUseCase {
    List<Item> findLowestPricesItemsByBrand(Long brandId);
}
