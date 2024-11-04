package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.Item;

public interface ItemRetrieveUseCase {

    Item retrieve(Long itemId);
}
