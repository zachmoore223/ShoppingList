package com.shoppingList.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    public void testEntity() {
        Item test = new Item ("Tester");
        assertEquals("Tester", test.getName());
    }

}