package com.repository;

import com.base.Purchase;
import com.custom.PurchaseApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseApiRepository extends JpaRepository<Purchase, Long>, PurchaseApiRepositoryCustom {
}
