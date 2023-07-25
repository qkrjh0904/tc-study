package com.tc.spring.domain.item.model.dto;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import lombok.Getter;

@Getter
public class FindItemDto {

    private String itemNumber;

    private String name;

    private Integer price;

    private ItemType itemType;

    private SellingStatus sellingStatus;

    public static FindItemDto of(Item item) {
        FindItemDto dto = new FindItemDto();
        dto.itemNumber = item.getItemNumber();
        dto.name = item.getName();
        dto.price = item.getPrice();
        dto.itemType = item.getItemType();
        dto.sellingStatus = item.getSellingStatus();
        return dto;
    }
}
