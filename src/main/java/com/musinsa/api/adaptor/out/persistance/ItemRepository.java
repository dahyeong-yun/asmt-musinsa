package com.musinsa.api.adaptor.out.persistance;

import com.musinsa.api.adaptor.out.persistance.entity.ItemEntity;
import com.musinsa.api.adaptor.out.persistance.jpa.BrandJpaRepository;
import com.musinsa.api.adaptor.out.persistance.jpa.ItemJpaRepository;
import com.musinsa.api.adaptor.out.persistance.projcetion.BrandLowestPriceResult;
import com.musinsa.api.adaptor.out.persistance.projcetion.CategoryLowestPriceResult;
import com.musinsa.api.application.port.out.BrandItemOutputPort;
import com.musinsa.api.application.port.out.ItemOutputPort;
import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Category;
import com.musinsa.api.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ItemRepository implements ItemOutputPort, BrandItemOutputPort {
    private final ItemJpaRepository itemJpaRepository;
    private final BrandJpaRepository brandJpaRepository;

    @Override
    public Item save(Item item) {
        ItemEntity itemCandidate = ItemEntity.from(item);
        ItemEntity itemEntity = itemJpaRepository.save(itemCandidate);
        return itemEntity.toDomain(item.getBrand());
    }

    @Override
    public void deleteById(Long itemId) {
        itemJpaRepository.deleteById(itemId);
    }

    @Override
    public Optional<Item> findById(Long itemId) {
        return itemJpaRepository.findById(itemId)
                .map(itemEntity -> itemEntity.toDomain(
                        Objects.requireNonNull(brandJpaRepository.findById(itemEntity.getBrandId()).orElse(null)).toDomain())
                );
        // TODO  N + 1 형태 해결 필요
        // TODO not null 처리가 너무 복잡함
    }

    @Override
    public Optional<List<Item>> findByBrandId(Long brandId) {
        List<ItemEntity> findItems = itemJpaRepository.findByBrandId(brandId);
        return Optional.of(findItems.stream()
                .map(ItemEntity::toDomain)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Item> findLowestPriceCategorySetPerBrand() {
        List<BrandLowestPriceResult> findItems = itemJpaRepository.findLowestPriceCategorySetPerBrand();
        return findItems.stream()
                .map(BrandLowestPriceResult::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findLowestPriceCategorySetAcrossBrands() {
        List<CategoryLowestPriceResult> findItems = itemJpaRepository.findLowestPriceCategorySetAcrossBrands();
        return findItems.stream()
                .map(CategoryLowestPriceResult::toDomain)
                .collect(Collectors.toList());
    }
}
