package com.tc.spring.domain.item.repository;

import com.tc.spring.db.entity.item.Item;
import com.tc.spring.db.enums.SellingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findBySellingStatusIn(List<SellingStatus> sellingStatusList);
}
