package com.musinsa.api.adaptor.in.web.request;

import lombok.Getter;
import lombok.NonNull;

public class BrandCreateRequest {
    @NonNull
    @Getter
    private String brandName;
    @NonNull
    @Getter
    private String businessNumber;
}
