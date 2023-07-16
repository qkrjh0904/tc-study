package com.example.tc.unit.commerce;

import com.example.tc.unit.item.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Commerce {

    private final List<Item> itemList = new ArrayList<>();

    public void add(Item item) {
        itemList.add(item);
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
