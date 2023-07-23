package com.tc.spring.domain.item.repository;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
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
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품을 등록할 수 있다.")
    void saveItemList() {
        // given
        Item bag1 = Item.create("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", 9_900_000, ItemType.BAG, SellingStatus.STOP_SELLING);

        // when
        List<Item> list = itemRepository.saveAll(List.of(bag1, bag2, bag3));

        // then
        assertThat(list).hasSize(3)
                .extracting("itemNumber", "name", "price", "itemType", "sellingStatus")
                .containsExactlyInAnyOrder(
                        tuple("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING),
                        tuple("002", "루이비똥백", 5_300_000, ItemType.BAG, SellingStatus.SOLD_OUT),
                        tuple("003", "에르메스백", 9_900_000, ItemType.BAG, SellingStatus.STOP_SELLING)
                );
    }


}