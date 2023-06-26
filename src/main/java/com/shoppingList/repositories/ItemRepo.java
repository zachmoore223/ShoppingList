package com.shoppingList.repositories;

import com.shoppingList.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository <Item, Long> {
}
