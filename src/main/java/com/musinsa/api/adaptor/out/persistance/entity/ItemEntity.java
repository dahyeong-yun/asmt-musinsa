package com.musinsa.api.adaptor.out.persistance.entity;

import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.ItemPrice;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private Long brandId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    public static ItemEntity from(Item itemCandidate) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.id = itemCandidate.getId();
        itemEntity.brandId = itemCandidate.getBrand().getId();
        itemEntity.category = itemCandidate.getCategory();
        itemEntity.price = itemCandidate.getItemPrice();
        return itemEntity;
    }

    public Item toDomain(Brand brand) {
        return Item.mapFromEntity(
                id,
                brand,
                category,
                ItemPrice.create(price)
        );
    }

    // 브랜드 조회가 필요하지 않은 경우
    public Item toDomain() {
        return Item.mapFromEntity(
                id,
                null,
                category,
                ItemPrice.create(price)
        );
    }
}
