package com.example.tc.unit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

    INVALID_ITEM_NUMBER("아이템은 1개 이상 주문 가능 합니다."),
    INVALID_ORDER_TIME("현재는 주문 시간이 아닙니다.")
    ;

    private final String description;
}
