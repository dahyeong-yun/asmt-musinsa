package com.musinsa.api.adaptor.out.persistance;

import com.musinsa.api.adaptor.out.persistance.entity.BrandEntity;
import com.musinsa.api.adaptor.out.persistance.jpa.BrandJpaRepository;
import com.musinsa.api.application.port.out.BrandOutputPort;
import com.musinsa.api.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BrandRepository implements BrandOutputPort {
    private final BrandJpaRepository brandJpaRepository;

    @Override
    public Brand save(Brand brand) {
        BrandEntity brandEntity = brandJpaRepository.save(BrandEntity.from(brand));
        return brandEntity.toDomain();
    }

    @Override
    public Optional<Brand> findById(Long brandId) {
        return brandJpaRepository.findById(brandId)
                .map(BrandEntity::toDomain);
    }

    @Override
    public void deleteById(Long brandId) {
        brandJpaRepository.deleteById(brandId);
    }
}
