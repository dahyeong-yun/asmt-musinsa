package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.AllCategoryItems;
import com.musinsa.api.domain.CategoryItems;

public interface PricesRetrieveUseCase {
    AllCategoryItems findLowestPricesOneBrand();

    AllCategoryItems findLowestPricesBrandMix();

    CategoryItems findLowestAndHighestPricesAtCategory(String categoryName);
}
