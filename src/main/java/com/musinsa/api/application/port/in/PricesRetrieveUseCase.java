package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.AllCategoryItems;
import com.musinsa.api.domain.CategoryItems;
import com.musinsa.api.domain.Items;

public interface PricesRetrieveUseCase {
    AllCategoryItems findLowestPriceCategorySetPerBrand();

    Items findLowestPriceCategorySetAcrossBrands();

    CategoryItems findLowestAndHighestPricesAtCategory(String categoryName);
}
