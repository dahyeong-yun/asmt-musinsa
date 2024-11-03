package com.musinsa.api.adaptor.out.persistance.entity;

import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import com.musinsa.api.domain.ItemPrice;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long brandId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private int price;

    public static ItemEntity from(Item itemCandidate) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.id = itemCandidate.getId();
        itemEntity.brandId = itemCandidate.getBrand().getId();
        itemEntity.category = itemCandidate.getCategory();
        return itemEntity;
    }

    public Item toDomain() {
        return Item.create(
                null,  // TODO Brand.empty()와 같은 Null Object Pattern 활용
                this.category,
                ItemPrice.create(BigDecimal.valueOf(this.price))
        );
    }
}
