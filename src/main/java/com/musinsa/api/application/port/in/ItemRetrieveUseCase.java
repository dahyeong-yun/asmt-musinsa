package com.musinsa.api.application.port.in;

import com.musinsa.api.domain.Item;

import java.util.List;

public interface ItemRetrieveUseCase {
    List<Item> retrieveAll();

    Item retrieve(Long itemId);
}
