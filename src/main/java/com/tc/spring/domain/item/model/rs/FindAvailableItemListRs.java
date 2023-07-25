package com.tc.spring.domain.item.model.rs;

import com.tc.spring.domain.item.model.dto.FindItemDto;
import lombok.Getter;

import java.util.List;

@Getter
public class FindAvailableItemListRs {
    private List<FindItemDto> list;

    public static FindAvailableItemListRs of(List<FindItemDto> list) {
        FindAvailableItemListRs rs = new FindAvailableItemListRs();
        rs.list = list;
        return rs;
    }
}
