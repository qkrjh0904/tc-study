package com.tc.spring.domain.item.service;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@ActiveProfiles("test")
class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FindItemService findItemService;

    @Autowired
    private ItemService itemService;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("가방과 컵을 저장할 수 있다.")
    void saveItemTest() {
        // given
        SaveItemRq rq1 = SaveItemRq.of("BAG-001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING);
        SaveItemRq rq2 = SaveItemRq.of("CUP-001", "텀블러", 21_000, ItemType.CUP, SellingStatus.SELLING);

        itemService.saveItem(rq1);
        itemService.saveItem(rq2);

        // when
        List<Item> list = findItemService.findAllItems();

        // then
        assertThat(list).hasSize(2)
                .extracting("itemNumber", "name", "price", "itemType", "sellingStatus")
                .containsExactlyInAnyOrder(
                        tuple("BAG-001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING),
                        tuple("CUP-001", "텀블러", 21_000, ItemType.CUP, SellingStatus.SELLING)
                );
    }

}