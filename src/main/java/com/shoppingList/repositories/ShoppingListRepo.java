package com.shoppingList.repositories;

import com.shoppingList.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepo extends CrudRepository <Long, Item> {
}
