package com.musinsa.api.application;

import com.musinsa.api.adaptor.in.web.request.BrandCreateRequest;
import com.musinsa.api.application.port.in.BrandCreateUseCase;
import com.musinsa.api.application.port.in.BrandDeleteUseCase;
import com.musinsa.api.application.port.in.BrandModifyUseCase;
import com.musinsa.api.application.port.in.BrandRetrieveUseCase;
import com.musinsa.api.application.port.out.BrandItemOutputPort;
import com.musinsa.api.application.port.out.BrandOutputPort;
import com.musinsa.api.domain.Brand;
import com.musinsa.api.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BrandService implements
        BrandCreateUseCase,
        BrandRetrieveUseCase,
        BrandModifyUseCase,
        BrandDeleteUseCase {

    private final BrandOutputPort brandOutputPort;
    private final BrandItemOutputPort brandItemOutputPort;

    @Override
    public Brand create(BrandCreateRequest request) {
        // TODO 브랜드 명 중복검사
        Brand brand = Brand.create(request.getBrandName());
        return brandOutputPort.save(brand);
    }

    @Override
    public List<Brand> retrieveAll() {
        return null;
    }

    @Override
    public Brand retrieve(Long brandId) {
        return brandOutputPort.findById(brandId)
                .orElseThrow(() -> new NoSearchResultException("Brand not found"));
    }

    @Override
    public void delete(Long brandId) {
        brandOutputPort.findById(brandId)
                .orElseThrow(() -> new NoSearchResultException("Brand not found"));

        // TODO null 처리 개선 필요
        List<Item> items = brandItemOutputPort.findByBrandId(brandId).orElse(null);
        if (!(items != null && items.isEmpty())) {
            throw new BrandItemExistException("Brand item exist");
        }
        brandOutputPort.deleteById(brandId);
    }

    @Override
    public void modify() {

    }
}
