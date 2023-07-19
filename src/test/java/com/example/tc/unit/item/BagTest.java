package com.example.tc.unit.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BagTest {

    @Test
    @DisplayName("Bag 단위 테스트")
    void test() {
        Bag bag = new Bag();
        assertThat(bag.getPrice()).isEqualTo(3000);
        assertThat(bag.getName()).isEqualTo("가방");
    }

}