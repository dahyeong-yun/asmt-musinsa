package com.musinsa.api.adaptor.in.web.request;

import lombok.Getter;

@Getter
public class ItemCreateRequest {
    private Long brandId;
    private String categoryName;
    private int price;
}
