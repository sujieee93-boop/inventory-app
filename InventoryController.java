package com.simplilearn.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final List<InventoryItem> items = new CopyOnWriteArrayList<>();
    private final AtomicLong sequence = new AtomicLong();

    public InventoryController() {
        items.add(new InventoryItem(sequence.incrementAndGet(), "Laptop", 10, 1200.00));
        items.add(new InventoryItem(sequence.incrementAndGet(), "Keyboard", 25, 49.99));
        items.add(new InventoryItem(sequence.incrementAndGet(), "Monitor", 15, 299.99));
    }

    @GetMapping
    public List<InventoryItem> list() { return items; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItem add(@RequestBody InventoryItem item) {
        item.setId(sequence.incrementAndGet());
        items.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}
