package com.tc.spring.domain.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import com.tc.spring.domain.item.model.dto.FindItemDto;
import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.model.rs.FindAllItemListRs;
import com.tc.spring.domain.item.service.FindItemService;
import com.tc.spring.domain.item.service.ItemService;
import com.tc.spring.domain.path.ApiPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private FindItemService findItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("새로운 아이템을 등록한다.")
    void saveItem() throws Exception {
        // given
        SaveItemRq rq = SaveItemRq.of("001", "샤넬백", 4_500_000, ItemType.BAG, SellingStatus.SELLING);

        // when // then
        mockMvc.perform(
                        MockMvcRequestBuilders.post(ApiPath.ITEM_V1)
                                .content(objectMapper.writeValueAsString(rq))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("새로운 아이템을 등록할때 ItemType 은 필수값이다.")
    void saveItemWithoutItemType() throws Exception {
        // given
        SaveItemRq rq = SaveItemRq.of("001", "샤넬백", 4_500_000, null, SellingStatus.SELLING);

        // when // then
        mockMvc.perform(
                        MockMvcRequestBuilders.post(ApiPath.ITEM_V1)
                                .content(objectMapper.writeValueAsString(rq))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("ItemType 은 필수값입니다."))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    @DisplayName("전체 Item 목록을 가져올 수 있다.")
    void findAllItemList() throws Exception {
        // given
        List<FindItemDto> list = List.of();
        FindAllItemListRs rs = FindAllItemListRs.of(list);
        Mockito.when(findItemService.findAllItemList()).thenReturn(rs);

        // when // then
        mockMvc.perform(
                        MockMvcRequestBuilders.get(ApiPath.ITEM_V1)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}