package com.musinsa.api.adaptor.out.persistance.projcetion;

import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.ItemPrice;

import java.math.BigDecimal;

public interface CategoryPriceRangeResult {
    String getCategory();

    Long getBrandId();

    String getBrandName();

    BigDecimal getPrice();

    Long getItemId();

    String getPriceType();  // 'MIN' 또는 'MAX' 값을 가짐

    default Item toDomain() {
        Brand brand = Brand.mapFromEntity(getBrandId(), getBrandName());
        return Item.mapFromEntity(
                getItemId(),
                brand,
                Category.valueOf(getCategory()),
                ItemPrice.create(getPrice())
        );
    }
}
