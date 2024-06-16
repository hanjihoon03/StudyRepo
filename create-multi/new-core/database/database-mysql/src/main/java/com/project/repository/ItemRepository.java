package com.project.repository;

import com.project.item.Item;
import com.project.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> , ItemRepositoryCustom {
}
