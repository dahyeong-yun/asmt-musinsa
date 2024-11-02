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
    private String category;

    @Column(nullable = false)
    private int price;

    public Item toDomain() {
        return Item.create(
                null,  // TODO Brand.empty()와 같은 Null Object Pattern 활용
                Category.valueOf(this.category),
                ItemPrice.create(BigDecimal.valueOf(this.price))
        );
    }
}
