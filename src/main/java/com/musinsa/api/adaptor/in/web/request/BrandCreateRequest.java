package com.musinsa.api.adaptor.in.web.request;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class BrandCreateRequest {
    @NonNull
    private String brandName;
    @NonNull
    private String businessNumber;
}
