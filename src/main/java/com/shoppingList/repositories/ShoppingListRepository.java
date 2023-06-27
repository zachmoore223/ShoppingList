package com.shoppingList.repositories;
import com.shoppingList.entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository <ShoppingList, String> {
}
