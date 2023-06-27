package com.shoppingList.controllers;

import com.shoppingList.entities.Item;
import com.shoppingList.entities.ShoppingList;
import com.shoppingList.repositories.ItemRepository;
import com.shoppingList.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ShoppingListController {
    final ShoppingListRepository shoppingListRepository;
    final ItemRepository itemRepository;

    public ShoppingListController(@Autowired ShoppingListRepository shoppingListRepository,
                          @Autowired ItemRepository itemRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/shoppingLists")
    public Iterable<ShoppingList> getShoppingLists(){
        // Call the findAll() method of the shoppingListRepository to get all shoppingLists in the database.
        return shoppingListRepository.findAll();
    }

    @GetMapping("/shoppingLists/{name}")
    public ShoppingList getShoppingList(@PathVariable String username) throws Exception {
        // Call the findById() method of the shoppingListRepository to retrieve the shoppingList with the given name.
        // If the list doesn't exist, throw a new Exception with a custom message.
        return shoppingListRepository.findById(username).orElseThrow(() -> new Exception("List not found: " + username));
    }

    //get all itmes in a shoppinglist
    @GetMapping("/shoppingLists/{name}/listOfItems")
    public Collection<Item> getShoppingListCollection(@PathVariable String username) throws Exception {
        // Call the findById() method of the userRepository to retrieve the user with the given username.
        // If the user doesn't exist, throw a new Exception with a custom message.
        return shoppingListRepository.findById(username).orElseThrow(() -> new Exception("Username not found: " + username))
                .getAllItems();
    }

    // This method uses the PUT method to add a new item to the collection of a specific shopping list in the database using their name and the item id.
    @PutMapping("/shoppingList/{name}/listOfItems/{item_id}")
    public void addItemToList(@PathVariable String name, @PathVariable Long item_id) throws Exception {
        // Call the findById() method of the shoppingListRepository to retrieve the list with the given name.
        // If the list doesn't exist, throw a new Exception with a custom message.
        ShoppingList list = shoppingListRepository.findById(name).orElseThrow(() -> new Exception("List not found: " + name));
        // Call the findById() method of the itemRepo to retrieve the item with the given item_id.
        // If the item doesn't exist, throw a new Exception with a custom message.
        Item item = itemRepository.findById(item_id).orElseThrow(() -> new Exception("Item id not found: " + item_id));
        // Call the addItem() method of the user to add the new item to their collection.
        list.addItem(item);
        // Call the save() method of the shoppingListRepository to update the list's data in the database.
        shoppingListRepository.save(list);
    }

    // This method uses the POST method to add a new user to the database.
    @PostMapping("/shoppingLists")
    public ShoppingList postShoppingList(@RequestBody ShoppingList list) {
        // Call the save() method of the shoppingListRepository to add the new user to the database and return it.
        return shoppingListRepository.save(list);
    }

    // This method uses the DELETE method to remove a specific item from the collection of a specific user in the database using their username and the item id.
    @DeleteMapping("/shoppingList/{name}/listOfItems/{item_id}")
    public void deleteItemFromList(@PathVariable String name, @PathVariable Long item_id) throws Exception {
        // Call the findById() method of the shoppingListRepository to retrieve the list with the given name.
        // If the list doesn't exist, throw a new Exception with a custom message.
        ShoppingList list = shoppingListRepository.findById(name).orElseThrow(() -> new Exception("Username not found: " + name));
        // Call the removeItem() method of the list to remove the item with the given item_id from their collection.
        list.removeItem(item_id);
        // Call the save() method of the shoppingListRepository to update the list's data in the database.
        shoppingListRepository.save(list);
    }


}
