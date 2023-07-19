package com.example.tc.unit.commerce;

import com.example.tc.unit.item.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.example.tc.unit.enums.ErrorMessage.INVALID_ITEM_NUMBER;

@Getter
public class Commerce {

    private final List<Item> itemList = new ArrayList<>();

    public void add(Item item, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(INVALID_ITEM_NUMBER.getDescription());
        }

        for (int i = 0; i < count; ++i) {
            itemList.add(item);
        }
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
