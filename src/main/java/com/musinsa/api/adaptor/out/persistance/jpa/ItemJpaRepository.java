package com.musinsa.api.adaptor.out.persistance.jpa;

import com.musinsa.api.adaptor.out.persistance.entity.ItemEntity;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByBrandId(Long brandId);
}
