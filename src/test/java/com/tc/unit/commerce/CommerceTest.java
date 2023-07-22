package com.tc.unit.commerce;

import com.tc.unit.commerce.Commerce;
import com.tc.unit.item.Bag;
import com.tc.unit.item.Cup;
import com.tc.unit.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.tc.unit.enums.ErrorMessage.INVALID_ITEM_NUMBER;
import static com.tc.unit.enums.ErrorMessage.INVALID_ORDER_TIME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommerceTest {

    @Test
    @DisplayName("아이템 1개를 추가하면 아이템 리스트에 담긴다.")
    void addItem() {
        Commerce commerce = new Commerce();
        commerce.add(new Bag(), 1);

        assertThat(commerce.getItemList()).hasSize(1);
        assertThat(commerce.getItemList().get(0).getPrice()).isEqualTo(3000);
    }

    @Test
    @DisplayName("아이템 여러개를 추가하면 아이템 리스트에 담긴다.")
    void addManyItems() {
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 2);
        commerce.add(cup, 1);

        assertThat(commerce.getItemList()).hasSize(3);
        assertThat(commerce.getItemList().get(0).getPrice()).isEqualTo(3000);
        assertThat(commerce.getItemList().get(1).getName()).isEqualTo("가방");
        assertThat(commerce.getItemList().get(2).getName()).isEqualTo("컵");
    }

    @Test
    @DisplayName("아이템 주문시 0이하의 숫자를 넣으면 IllegalArgumentException 이 발생한다.")
    void addItemWithZeroCount() {
        Commerce commerce = new Commerce();
        Bag bag = new Bag();

        assertThatThrownBy(() -> commerce.add(bag, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ITEM_NUMBER.getDescription());
        assertThatThrownBy(() -> commerce.add(bag, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ITEM_NUMBER.getDescription());
    }


    @Test
    @DisplayName("전체 아이템 리스트를 모두 비운다.")
    void clear() {
        // given
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 1);
        commerce.add(cup, 3);

        // when
        commerce.clear();

        // then
        assertThat(commerce.getItemList()).hasSize(0);
    }

    @Test
    @DisplayName("아이템 리스트에서 해당 아이템을 삭제할 수 있다.")
    void removeSpecificItem() {
        // given
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 1);
        commerce.add(cup, 3);

        // when
        commerce.clear(cup);

        // then
        assertThat(commerce.getItemList()).hasSize(1);
    }

    @Test
    @DisplayName("아이템 리스트에 있는 아이템 가격의 총 합을 계산할 수 있다.")
    void calculateTotalPrice() {
        // given
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 1);   // 3000 * 1 = 3000원
        commerce.add(cup, 3);   // 1000 * 3 = 3000원

        // when
        int totalPrice = commerce.calculateTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(6000);
    }

    @Test
    @DisplayName("주문 가능 시간 안에 주문을 할 수 있다.")
    void createOrderAtOpenTime() {
        // given
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 1);
        commerce.add(cup, 3);

        LocalDateTime nowDateTime = LocalDateTime.of(2023, 7, 19, 22, 59, 59);

        // when
        Order order = commerce.createOrder(nowDateTime);

        // then
        assertThat(order.getItemList()).hasSize(4);
        assertThat(order.getItemList().get(0).getName()).isEqualTo("가방");
    }

    @Test
    @DisplayName("주문 가능 시간 이외에는 주문할 수 없다. IllegalArgumentException 을 던진다.")
    void cannotCreateOrderAtEndTime() {
        // given
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 1);
        commerce.add(cup, 3);
        LocalDateTime nowDateTime = LocalDateTime.of(2023, 7, 19, 6, 0, 0);

        // when // then
        assertThatThrownBy(() -> commerce.createOrder(nowDateTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_TIME.getDescription());
    }
}