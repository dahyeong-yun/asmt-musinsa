package com.musinsa.api.adaptor.out.persistance.jpa;

import com.musinsa.api.adaptor.out.persistance.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<BrandEntity, Long> {
}
