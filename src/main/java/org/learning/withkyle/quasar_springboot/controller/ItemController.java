package org.learning.withkyle.quasar_springboot.controller;

import org.learning.withkyle.quasar_springboot.model.Item;
import org.learning.withkyle.quasar_springboot.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class ItemController {

    public ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
       return itemService.showAll();
    }

    // @GetMapping("/{id}")
    // public Item getItemById(@PathVariable int id) {
        
    // }

  

    @PostMapping("/create/item")
    public ResponseEntity<?> createItem(@RequestBody Item newItem) {
            Item item = itemService.addItem(newItem);
    return ResponseEntity.ok(item);
    }

    // @PutMapping("/{id}")
    // public Item updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
      
    // }

    // @DeleteMapping("/{id}")
    // public String deleteItem(@PathVariable int id) {
       
    // }
}
