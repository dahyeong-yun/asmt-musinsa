package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.AllCategoryItems;
import com.musinsa.api.domain.CategoryItems;

public interface LowestPricesRetrieveUseCase {
    AllCategoryItems findLowestPricesOneBrand();

    AllCategoryItems findLowestPricesBrandMix();

    CategoryItems findLowestPricesAtCategory(String categoryName);
}
