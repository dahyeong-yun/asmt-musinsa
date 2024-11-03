package com.musinsa.api.application.port.in;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemCreateCommand {
    private Long brandId;
    private String categoryName;
    private BigDecimal price;

    @Builder(access = AccessLevel.PRIVATE)
    public ItemCreateCommand(Long brandId, String categoryName, BigDecimal price) {
        this.brandId = brandId;
        this.categoryName = categoryName;
        this.price = price;
    }

    public static ItemCreateCommand from(ItemCreateRequest request) {
        return ItemCreateCommand.builder()
                .brandId(request.getBrandId())
                .categoryName(request.getCategoryName())
                .price(BigDecimal.valueOf(request.getPrice()))
                .build();
    }
}
