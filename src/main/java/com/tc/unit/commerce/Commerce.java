package com.tc.unit.commerce;

import com.tc.unit.item.Item;
import com.tc.unit.order.Order;
import com.tc.unit.enums.ErrorMessage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Commerce {

    private static final LocalTime ORDER_START_TIME = LocalTime.of(6, 0);
    private static final LocalTime ORDER_END_TIME = LocalTime.of(23, 0);

    private final List<Item> itemList = new ArrayList<>();

    public void add(Item item, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ITEM_NUMBER.getDescription());
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

    public void clear() {
        itemList.clear();
    }

    public void clear(Item item) {
        itemList.removeIf(it -> it.equals(item));
    }

    public Order createOrder(LocalDateTime nowDateTime) {
        LocalTime now = nowDateTime.toLocalTime();
        if (now.isAfter(ORDER_START_TIME) && now.isBefore(ORDER_END_TIME)) {
            return new Order(nowDateTime, itemList);
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_TIME.getDescription());
    }
}
