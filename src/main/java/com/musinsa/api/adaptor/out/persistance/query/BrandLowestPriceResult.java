package com.musinsa.api.adaptor.out.persistance.query;

import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.ItemPrice;
import lombok.Getter;

import java.math.BigDecimal;

public interface BrandLowestPriceResult {
    Long getBrandId();
    String getBrandName();
    Long getTotalPrice();
    String getCategory(); // String으로 받아서 나중에 변환
    BigDecimal getPrice();
    Long getItemId();

    default Item toDomain() {
        Brand brand = Brand.mapFromEntity(getBrandId(), getBrandName());
        return Item.mapFromEntity(
                getItemId(),
                brand,
                Category.valueOf(getCategory()), // String을 Enum으로 변환
                ItemPrice.create(getPrice())
        );
    }
}
