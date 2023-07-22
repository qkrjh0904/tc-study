package com.tc.unit.item;

public class Bag implements Item {
    @Override
    public int getPrice() {
        return 3000;
    }

    @Override
    public String getName() {
        return "가방";
    }
}
