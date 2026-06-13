package com.cafe12.controller;

import com.cafe12.entity.CafeItem;
import com.cafe12.repository.CafeItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeItemController {

    private final CafeItemRepository repository;


    // 1. GET all items
    @GetMapping
    public List<CafeItem> getAllItems() {
        return repository.findAll();
    }

    // 2. GET a single item by ID
    @GetMapping("/{id}")
    public ResponseEntity<CafeItem> getItemById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST to add a new item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CafeItem addItem(@RequestBody CafeItem item) {
        return repository.save(item);
    }

    // 4. DELETE an item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
