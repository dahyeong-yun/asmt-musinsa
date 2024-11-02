package com.musinsa.api.adaptor.out.persistance.jpa;

import com.musinsa.api.adaptor.out.persistance.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByBrandId(Long brandId);
}
