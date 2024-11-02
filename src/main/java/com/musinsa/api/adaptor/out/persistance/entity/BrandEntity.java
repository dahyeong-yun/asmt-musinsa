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

    public static BrandEntity from(Brand brand) {
        BrandEntity entity = new BrandEntity();
        entity.id = brand.getId();
        entity.brandName = brand.getBrandName();
        return entity;
    }

    public Brand toDomain() {
        return Brand.builder()
                .id(id)
                .brandName(brandName)
                .build();
    }
}
