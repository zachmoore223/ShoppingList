package com.shoppingList.RestControllers;

import com.shoppingList.entities.Item;
import com.shoppingList.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ItemController {

    final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping ("/items")
    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    // This method uses the GET method to retrieve a specific item from the database using its id.
    @GetMapping("/items/{item_id}")
    public Item getItem(@PathVariable long item_id) throws Exception {
        return itemRepository.findById(item_id).orElseThrow(() -> new Exception("Plant id not found: " + item_id));
    }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item) {
    return itemRepository.save(item);
    }

}

