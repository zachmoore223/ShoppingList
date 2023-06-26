package com.shoppingList.entities;

import com.shoppingList.entities.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ShoppingList {
    @Id
    private String name;
    @ManyToOne()
    @JoinTable()
    private Map<Long, Item> shoppingList = new HashMap<>();

    public ShoppingList() {
        this.shoppingList = shoppingList;
    }

    public ShoppingList(String name) {
    }

    public Map<Long, Item> getShoppingList() {
        return shoppingList;
    }

    public Collection<Item> getAllItems(){
        return shoppingList.values();
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
