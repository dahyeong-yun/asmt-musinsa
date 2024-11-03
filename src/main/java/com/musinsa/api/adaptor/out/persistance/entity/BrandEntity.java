package com.musinsa.api.adaptor.out.persistance.entity;

import com.musinsa.api.domain.Brand;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brandName;

    public static BrandEntity from(Brand brandCandidate) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.id = brandCandidate.getId();
        brandEntity.brandName = brandCandidate.getBrandName();
        return brandEntity;
    }

    public Brand toDomain() {
        return Brand.mapFromEntity(
                id,
                brandName
        );
    }
}
