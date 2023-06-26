package com.shoppingList.repositories;
import com.shoppingList.entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepo extends CrudRepository <ShoppingList, String> {
}
