package com.example.tc.unit.item;

public class Cup implements Item {
    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public String getName() {
        return "컵";
    }
}
