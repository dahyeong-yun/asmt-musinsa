package com.musinsa.api.application.port.out;

import com.musinsa.api.domain.Item;

public interface ItemOutputPort {
    Item save(Item item);
}

