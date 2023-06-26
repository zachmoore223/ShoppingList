package com.shoppingList.entities;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {
    @Test
    public void testShoppingList() {
        Item test = new Item ("Tester");
        ShoppingList testList = new ShoppingList("testList");
        testList.addItem(test);
        assertEquals(1, testList.getAllItems().size());
        assertEquals("Tester", testList.getItem(0L).getName());
    }
}