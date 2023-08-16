package com.tc.spring.domain.item.model.rq;

import com.tc.spring.db.entity.item.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class SaveItemRq {

    @NotBlank
    private String itemNumber;

    @NotBlank
    private String name;

    @NotNull
    private Integer price;

    @NotNull(message = "ItemType 은 필수값입니다.")
    private ItemType itemType;

    @NotNull
    private SellingStatus sellingStatus;

    public Item toEntity() {
        return Item.create(itemNumber, name, price, itemType, sellingStatus);
    }

    public static SaveItemRq of(String itemNumber, String name, Integer price, ItemType itemType, SellingStatus sellingStatus) {
        SaveItemRq rq = new SaveItemRq();
        rq.itemNumber = itemNumber;
        rq.name = name;
        rq.price = price;
        rq.itemType = itemType;
        rq.sellingStatus = sellingStatus;
        return rq;
    }
}
