package com.musinsa.api.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Items {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item findLowestPriceItem() {
        return items.stream()
                .min(Comparator.comparing(Item::getItemPrice))
                .orElseThrow();
    }

    public Item findHighestPriceItem() {
        return items.stream()
                .max(Comparator.comparing(Item::getItemPrice))
                .orElseThrow();
    }
}
