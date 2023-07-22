package com.tc.unit.item;

import com.tc.unit.item.Cup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CupTest {

    @Test
    @DisplayName("컵 유닛 테스트")
    void cupUnitTest() {
        Cup cup = new Cup();

        assertThat(cup.getPrice()).isEqualTo(1000);
        assertThat(cup.getName()).isEqualTo("컵");
    }
}