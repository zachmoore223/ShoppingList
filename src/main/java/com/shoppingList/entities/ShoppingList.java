package com.shoppingList.entities;

import com.shoppingList.entities.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

import java.util.HashMap;
import java.util.Map;

@Entity
public class ShoppingList {

    @ManyToOne()
    @JoinTable()
    private Map<Long, Item> shoppingList = new HashMap<>();

    public ShoppingList(Map<Long, Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Map<Long, Item> getShoppingList() {
        return shoppingList;
    }

    public Item getItem (Long id) {
        return shoppingList.get(id);
    }

    public void addItem(Item item) {
        shoppingList.put(item.getId(), item);
    }

    public void removeItem(Long id) {
        shoppingList.remove(id);
    }



}
