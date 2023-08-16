package com.tc.spring.domain.item.service;


import com.tc.spring.db.entity.item.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
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
class FindItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FindItemService findItemService;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("판매 상태가 판매중, 매진인 경우만 조회 할 수 있다.")
    void findAvailableItems() {
        // given
        Item bag1 = Item.create("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", 9_900_000, ItemType.BAG, SellingStatus.STOP_SELLING);
        Item bag4 = Item.create("004", "구찌백", 3_200_000, ItemType.BAG, SellingStatus.STOP_SELLING);
        itemRepository.saveAll(List.of(bag1, bag2, bag3, bag4));

        // when
        List<Item> list = findItemService.findAvailableItems();

        // then
        assertThat(list).hasSize(2)
                .extracting("itemNumber", "name", "price", "itemType", "sellingStatus")
                .containsExactlyInAnyOrder(
                        tuple("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING),
                        tuple("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT)
                );
    }

    @Test
    @DisplayName("모든 상품을 찾아올 수 있다.")
    void findAllItems() {
        // given
        Item bag1 = Item.create("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", 9_900_000, ItemType.BAG, SellingStatus.STOP_SELLING);
        Item bag4 = Item.create("004", "구찌백", 3_200_000, ItemType.BAG, SellingStatus.STOP_SELLING);
        itemRepository.saveAll(List.of(bag1, bag2, bag3, bag4));

        // when
        List<Item> list = findItemService.findAllItems();

        // then
        assertThat(list).hasSize(4)
                .extracting("itemNumber", "name", "price", "itemType", "sellingStatus")
                .containsExactlyInAnyOrder(
                        tuple("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING),
                        tuple("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT),
                        tuple("003", "에르메스백", 9_900_000, ItemType.BAG, SellingStatus.STOP_SELLING),
                        tuple("004", "구찌백", 3_200_000, ItemType.BAG, SellingStatus.STOP_SELLING)
                );
    }

}