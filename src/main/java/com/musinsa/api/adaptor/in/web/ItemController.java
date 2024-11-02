package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import com.musinsa.api.application.port.in.ItemCreateUseCase;
import com.musinsa.api.application.port.in.ItemRetrieveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
@RestController
public class ItemController {
    private final ItemRetrieveUseCase itemRetrieveUseCase;
    private final ItemCreateUseCase itemCreateUseCase;

    @PostMapping
    public ResponseEntity create(ItemCreateRequest request) {
        var itemId = itemCreateUseCase.create(request);
        return ResponseEntity
                .created(URI.create("/api/v1/items/" + itemId))
                .build();
    }

    @GetMapping
    public ResponseEntity retrieveAll() {
        var items = itemRetrieveUseCase.retrieveAll();
        return ResponseEntity
                .ok()
                .body(items);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity retrieve(@PathVariable String itemId) {
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity delete(@PathVariable String itemId) {
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity modify(@PathVariable String itemId) {
        return ResponseEntity
                .ok()
                .build();
    }
}