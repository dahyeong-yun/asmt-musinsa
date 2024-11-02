package com.musinsa.api.application;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import com.musinsa.api.application.port.in.ItemCreateUseCase;
import com.musinsa.api.application.port.in.ItemRetrieveUseCase;
import com.musinsa.api.application.port.in.LowestCategoryPricesUseCase;
import com.musinsa.api.application.port.out.ItemOutputPort;
import com.musinsa.api.domain.Item;
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
        LowestCategoryPricesUseCase {

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
    public List<Item> findLowestPricesItemsByBrand(Long brandId) {

        // 브랜드 기준 상품을 다 가져옴
        // 카테고리 기준 그룹핑 -> 애초에 쿼리로 하면 편하긴 함
        // 카테고리별 최저 상품 하나씩만 남김, 카테고리 유형과 순서는 고정


        return null;
    }
}
