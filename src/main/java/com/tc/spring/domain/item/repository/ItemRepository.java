package com.tc.spring.domain.item.repository;

import com.tc.spring.db.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
