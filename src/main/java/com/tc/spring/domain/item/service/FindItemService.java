package com.tc.spring.domain.item.service;

import com.tc.spring.db.entity.item.Item;
import com.tc.spring.db.enums.SellingStatus;
import com.tc.spring.domain.item.model.dto.FindItemDto;
import com.tc.spring.domain.item.model.rs.FindAllItemListRs;
import com.tc.spring.domain.item.model.rs.FindAvailableItemListRs;
import com.tc.spring.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.tc.spring.db.enums.SellingStatus.SELLING;
import static com.tc.spring.db.enums.SellingStatus.SOLD_OUT;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAvailableItems() {
        return itemRepository.findBySellingStatusIn(List.of(SELLING, SOLD_OUT));
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public FindAllItemListRs findAllItemList() {
        List<FindItemDto> list = itemRepository.findAll().stream()
                .map(FindItemDto::of)
                .collect(Collectors.toList());
        return FindAllItemListRs.of(list);
    }

    public FindAvailableItemListRs findAvailableItemList() {
        List<SellingStatus> availableSellingStatus = List.of(SELLING, SOLD_OUT);
        List<FindItemDto> list = itemRepository.findBySellingStatusIn(availableSellingStatus).stream()
                .map(FindItemDto::of)
                .collect(Collectors.toList());
        return FindAvailableItemListRs.of(list);
    }
}
