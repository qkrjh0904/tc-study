package com.tc.spring.domain.item.service;

import com.tc.spring.db.entity.Item;
import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(SaveItemRq rq) {
        Item item = rq.toEntity();
        itemRepository.save(item);
    }

}
