package com.musinsa.api.adaptor.out.persistance;

import com.musinsa.api.adaptor.out.persistance.jpa.ItemJpaRepository;
import com.musinsa.api.application.port.out.ItemOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ItemRepository implements ItemOutputPort {
    private final ItemJpaRepository itemJpaRepository;
}
