package com.musinsa.api.application;

import com.musinsa.api.application.port.in.*;
import com.musinsa.api.application.port.in.command.ItemCreateCommand;
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
    public Item retrieve(Long itemId) {
        return itemOutputPort.findById(itemId)
                .orElseThrow(() -> new NoSearchResultException("Item not found"));
    }

    @Override
    public AllCategoryItems findLowestPriceCategorySetPerBrand() {
        List<Item> items = itemOutputPort.findLowestPriceCategorySetPerBrand();
        return AllCategoryItems.of(items.getFirst().getBrand(), items);
    }

    @Override
    public Items findLowestPriceCategorySetAcrossBrands() {
        List<Item> findItems = itemOutputPort.findLowestPriceCategorySetAcrossBrands();
        return Items.create(findItems);
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

        Items items = Items.create(findItems);
        return CategoryItems.of(category, items);
    }

    @Override
    public void delete(Long itemId) {
        itemOutputPort.findById(itemId)
                .orElseThrow(() -> new NoSearchResultException("Item not found"));
        itemOutputPort.deleteById(itemId);
    }
}
