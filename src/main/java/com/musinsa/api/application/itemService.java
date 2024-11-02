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
    public AllCategoryItems findLowestPricesBrandMix() {
        return null;
    }

    @Override
    public CategoryItems findLowestAndHighestPricesAtCategory(String categoryName) {
        return null;
    }
}
