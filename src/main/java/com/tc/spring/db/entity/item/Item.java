package com.tc.spring.db.entity.item;

import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemNumber;

    private String name;

    private Integer price;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Enumerated(EnumType.STRING)
    private SellingStatus sellingStatus;

    public static Item create(String itemNumber, String name, Integer price,
                              ItemType itemType, SellingStatus sellingStatus) {
        Item item = new Item();
        item.itemNumber = itemNumber;
        item.name = name;
        item.price = price;
        item.itemType = itemType;
        item.sellingStatus = sellingStatus;
        return item;
    }
}
