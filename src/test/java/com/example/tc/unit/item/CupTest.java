package com.example.tc.unit.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CupTest {

    @Test
    @DisplayName("Bag 단위 테스트")
    void test() {
        Cup cup = new Cup();

        assertThat(cup.getPrice()).isEqualTo(1000);
        assertThat(cup.getName()).isEqualTo("컵");
    }

}