package com.tc.spring.db.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    BAG("가방"),

    CUP("컵");

    private final String description;

}
