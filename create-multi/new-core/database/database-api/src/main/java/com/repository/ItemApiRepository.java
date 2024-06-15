package com.repository;


import com.base.item.Item;
import com.custom.ItemApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemApiRepository extends JpaRepository<Item, Long>, ItemApiRepositoryCustom {
    List<Item> findByDtype(String dtype);
}
