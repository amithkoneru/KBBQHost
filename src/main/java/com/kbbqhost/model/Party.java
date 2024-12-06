package com.kbbqhost.model;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private int size;
    private Menu menu;
    private List<Item> orderedItems;

    public Party(int size, Menu menu)   {
        this.size = size;
        this.menu = menu;
        this.orderedItems = new ArrayList<Item>();
    }

    public int getSize() {
        return size;
    }

    public Menu getMenu()   {
        return menu;
    }

    public List<Item> getOrderedItems() {
        return orderedItems;
    }

    public void addOrder(Item item) {
        orderedItems.add(item);
    }

    public void removeOrder(Item item) {
        orderedItems.remove(item);
    }

    public int countItems() {
        return orderedItems.size();
    }

    public double calculateTotalPrice() {
        return size * menu.getPrice();
    }
}
