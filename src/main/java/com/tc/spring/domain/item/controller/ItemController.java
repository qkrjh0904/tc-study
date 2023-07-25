package com.tc.spring.domain.item.controller;

import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.model.rs.FindAllItemListRs;
import com.tc.spring.domain.item.model.rs.FindAvailableItemListRs;
import com.tc.spring.domain.item.service.FindItemService;
import com.tc.spring.domain.item.service.ItemService;
import com.tc.spring.domain.path.ApiPath;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final FindItemService findItemService;

    @PostMapping(ApiPath.ITEM_V1)
    public void saveItem(@RequestBody @Validated SaveItemRq rq) {
        itemService.saveItem(rq);
    }

    @GetMapping(ApiPath.ITEM_V1)
    public FindAllItemListRs findAllItemList() {
        return findItemService.findAllItemList();
    }

    @GetMapping(ApiPath.ITEM_V1_AVAILABLE)
    public FindAvailableItemListRs findAvailableItemList() {
        return findItemService.findAvailableItemList();
    }
}
