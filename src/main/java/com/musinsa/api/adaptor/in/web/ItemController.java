package com.musinsa.api.adaptor.in.web;

import com.musinsa.api.adaptor.in.web.request.ItemCreateRequest;
import com.musinsa.api.adaptor.in.web.request.ItemRetrieveResponse;
import com.musinsa.api.application.port.in.ItemCreateCommand;
import com.musinsa.api.application.port.in.ItemCreateUseCase;
import com.musinsa.api.application.port.in.ItemDeleteUseCase;
import com.musinsa.api.application.port.in.ItemRetrieveUseCase;
import com.musinsa.api.domain.Item;
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
    private final ItemDeleteUseCase itemDeleteUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody ItemCreateRequest request) {
        var command = ItemCreateCommand.from(request);
        var item = itemCreateUseCase.create(command);
        var response = ItemRetrieveResponse.of(item);
        return ResponseEntity
                .created(URI.create("/api/v1/items/" + item.getId()))
                .body(response);
    }

    @GetMapping
    public ResponseEntity retrieveAll() {
        // TODO paging
        var items = itemRetrieveUseCase.retrieveAll();
        return ResponseEntity
                .ok()
                .body(items);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity retrieve(@PathVariable(name = "itemId") Long itemId) {
        var item = itemRetrieveUseCase.retrieve(itemId);
        var response = ItemRetrieveResponse.of(item);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity delete(@PathVariable(name = "itemId")  Long itemId) {
        itemDeleteUseCase.delete(itemId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity modify(@PathVariable(name = "itemId")  Long itemId) {
        return ResponseEntity
                .ok()
                .build();
    }
}
