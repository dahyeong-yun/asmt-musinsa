package com.musinsa.api.application;

import com.musinsa.api.application.port.in.*;
import com.musinsa.api.application.port.out.BrandOutputPort;
import com.musinsa.api.application.port.out.ItemOutputPort;
import com.musinsa.api.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class itemService implements
        ItemCreateUseCase,
        ItemRetrieveUseCase,
        ItemDeleteUseCase,
        PricesRetrieveUseCase {

    private final ItemOutputPort itemOutputPort;
    private final BrandOutputPort brandOutputPort;

    @Override
    public Item create(ItemCreateCommand itemCreateCommand) {
        Brand brand = brandOutputPort.findById(itemCreateCommand.brandId())
                .orElseThrow(/* TODO Custom Exception */);
        Category category = Category.fromString(itemCreateCommand.categoryName());
        Item itemCandidate = Item.create(
                brand,
                category,
                ItemPrice.create(itemCreateCommand.price())
        );
        return itemOutputPort.save(itemCandidate);
    }

    @Override
    public List<Item> retrieveAll() {
        return null;
    }

    @Override
    public Item retrieve(Long itemId) {
        return itemOutputPort.findById(itemId)
                .orElseThrow(() -> new NoSearchResultException("Item not found"));
    }

    @Override
    public AllCategoryItems findLowestPricesOneBrand() {
        // 브랜드 기준 상품을 다 가져옴
        // 카테고리 기준 그룹핑 -> 애초에 쿼리로 하면 편하긴 함
        // 카테고리별 최저 상품 하나씩만 남김, 카테고리 유형과 순서는 고정

        Brand brand = Brand.create("테스트");
        List<Item> items = List.of(
                Item.of(brand, Category.TOP, "10000"),
                Item.of(brand, Category.OUTER, "30000"),
                Item.of(brand, Category.PANTS, "10000"),
                Item.of(brand, Category.SNEAKERS, "10000"),
                Item.of(brand, Category.BAG, "10000"),
                Item.of(brand, Category.CAP, "10000"),
                Item.of(brand, Category.SOCKS, "10000"),
                Item.of(brand, Category.ACCESSORY, "20000")
        );
        return AllCategoryItems.of(brand, items);
        // TODO items 를 객체로 변경 하여 최저가를 구하는 로직을 포함 시키는 것이 좋을 것 같음
    }

    @Override
    public Items findLowestPricesBrandMix() {
        Brand adidas = Brand.create("A");
        Brand calvinKlein = Brand.create("C");
        Brand dior = Brand.create("D");
        Brand escada = Brand.create("E");
        Brand fendi = Brand.create("F");
        Brand gucci = Brand.create("G");

        Brand ironman = Brand.create("I");

        List<Item> findItems = List.of(
                Item.of(calvinKlein, Category.TOP, "10000"),
                Item.of(escada, Category.OUTER, "5000"),
                Item.of(dior, Category.PANTS, "3000"),
                Item.of(gucci, Category.SNEAKERS, "9000"),
                Item.of(adidas, Category.BAG, "2000"),
                Item.of(dior, Category.CAP, "1500"),
                Item.of(ironman, Category.SOCKS, "1700"),
                Item.of(fendi, Category.ACCESSORY, "1900")
        );
        return getItems(findItems);
    }

    @Override
    public CategoryItems findLowestAndHighestPricesAtCategory(String categoryName) {
        Category category = Category.fromString(categoryName);

        Brand calvinKlein = Brand.create("C");
        Brand ironman = Brand.create("I");

// TODO        itemOutputPort.findByCategory(category);

        List<Item> findItems = List.of(
                Item.of(calvinKlein, Category.TOP, "10000"),
                Item.of(ironman, Category.OUTER, "11400")
        );
        Items items = getItems(findItems);
        return CategoryItems.of(category, items);
    }

    // TODO 대체 및 삭제
    private static Items getItems(List<Item> findItems) {
        Items items = Items.create();
        findItems.forEach(items::add);
        return items;
    }

    @Override
    public void delete(Long itemId) {
        itemOutputPort.findById(itemId)
                .orElseThrow(() -> new NoSearchResultException("Item not found"));
        itemOutputPort.deleteById(itemId);
    }
}
