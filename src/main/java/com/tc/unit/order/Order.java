package com.tc.unit.order;


import com.tc.unit.item.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Order {
    private final LocalDateTime createdDateTime;
    private final List<Item> itemList;
}
