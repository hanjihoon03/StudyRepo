package com.project.repository;


import com.project.item.Item;
import com.project.custom.ItemApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemApiRepository extends JpaRepository<Item, Long>, ItemApiRepositoryCustom {
    List<Item> findByDtype(String dtype);
}
