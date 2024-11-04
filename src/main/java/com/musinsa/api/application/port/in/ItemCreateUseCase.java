package com.musinsa.api.application.port.in;

import com.musinsa.api.application.port.in.command.ItemCreateCommand;
import com.musinsa.api.domain.Item;

public interface ItemCreateUseCase {
    Item create(ItemCreateCommand itemCreateCommand);
}
