package com.musinsa.api.application;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import com.musinsa.api.application.port.in.ItemCreateUseCase;
import com.musinsa.api.application.port.in.ItemRetrieveUseCase;
import com.musinsa.api.application.port.in.PricesRetrieveUseCase;
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
        ItemRetrieveUseCase,
        ItemCreateUseCase,
        PricesRetrieveUseCase {

    private final ItemOutputPort itemOutputPort;

    @Override
    public String create(ItemCreateRequest request) {
        return null;
    }

    @Override
    public List<Item> retrieveAll() {
        return null;
    }

    @Override
    public AllCategoryItems findLowestPricesOneBrand() {
        // 브랜드 기준 상품을 다 가져옴
        // 카테고리 기준 그룹핑 -> 애초에 쿼리로 하면 편하긴 함
        // 카테고리별 최저 상품 하나씩만 남김, 카테고리 유형과 순서는 고정

        Brand brand = Brand.builder().brandName("테스트").businessNumber("23").build();
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
        Brand adidas = Brand.builder().brandName("A").businessNumber("23").build();
        Brand calvinKlein = Brand.builder().brandName("C").businessNumber("24").build();
        Brand dior = Brand.builder().brandName("D").businessNumber("24").build();
        Brand escada = Brand.builder().brandName("E").businessNumber("24").build();
        Brand fendi = Brand.builder().brandName("F").businessNumber("24").build();
        Brand gucci = Brand.builder().brandName("G").businessNumber("24").build();

        Brand ironman = Brand.builder().brandName("I").businessNumber("24").build();

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

        Brand calvinKlein = Brand.builder().brandName("C").businessNumber("24").build();
        Brand ironman = Brand.builder().brandName("I").businessNumber("24").build();

// TODO        itemOutputPort.findByCategory(category);

        List<Item> findItems = List.of(
                Item.of(calvinKlein, Category.TOP, "10000"),
                Item.of(ironman, Category.OUTER, "11400")
        );
        Items items = getItems(findItems);
        return CategoryItems.of(category, items);
    }

    private static Items getItems(List<Item> findItems) {
        Items items = Items.create();
        findItems.forEach(items::add);
        return items;
    }
}
