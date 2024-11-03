package com.musinsa.api.application.port.out;

import com.musinsa.api.domain.Item;

import java.util.Optional;

public interface ItemOutputPort {
    Item save(Item item);

    Optional<Item> findById(Long itemId);
}

