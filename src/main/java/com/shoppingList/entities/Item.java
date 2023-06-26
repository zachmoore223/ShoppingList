package com.shoppingList.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public void setId(final long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}