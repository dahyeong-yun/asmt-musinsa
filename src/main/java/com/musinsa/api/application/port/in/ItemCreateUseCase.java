package com.musinsa.api.application.port.in;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;

public interface ItemCreateUseCase {
    String create(ItemCreateRequest request);
}
