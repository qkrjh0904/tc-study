package com.tc.unit.item;

import com.tc.unit.item.Bag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BagTest {

    @Test
    @DisplayName("가방 유닛 테스트")
    void bagUnitTest() {
        Bag bag = new Bag();
        Assertions.assertThat(bag.getPrice()).isEqualTo(3000);
        Assertions.assertThat(bag.getName()).isEqualTo("가방");
    }

}