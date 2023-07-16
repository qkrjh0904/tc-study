package com.example.tc.unit.commerce;

import com.example.tc.unit.item.Bag;
import com.example.tc.unit.item.Cup;

public class CommerceRunner {

    public static void main(String[] args) {
        Commerce commerce = new Commerce();
        commerce.add(new Bag());
        System.out.println(">> 가방 추가");

        Cup cup = new Cup();
        commerce.add(cup);
        System.out.println(">> 컵 추가");
        commerce.add(cup);
        System.out.println(">> 컵 추가");

        int totalPrice = commerce.calculateTotalPrice();
        System.out.println(">> 총 주문 가격 : " + totalPrice);
    }

}
