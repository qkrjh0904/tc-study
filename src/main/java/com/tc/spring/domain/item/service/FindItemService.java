package com.tc.spring.domain.item.service;

import com.tc.spring.db.entity.Item;
import com.tc.spring.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
