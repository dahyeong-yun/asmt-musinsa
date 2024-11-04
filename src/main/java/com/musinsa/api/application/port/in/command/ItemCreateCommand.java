package com.musinsa.api.application.port.in.command;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import lombok.AccessLevel;
import lombok.Builder;

import java.math.BigDecimal;
@Builder(access = AccessLevel.PRIVATE)
public record ItemCreateCommand(Long brandId, String categoryName, BigDecimal price) {

    public static ItemCreateCommand from(ItemCreateRequest request) {
        return ItemCreateCommand.builder()
                .brandId(request.getBrandId())
                .categoryName(request.getCategoryName())
                .price(BigDecimal.valueOf(request.getPrice()))
                .build();
    }
}
