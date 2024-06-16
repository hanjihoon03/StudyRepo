package com.project.repository;

import com.project.Purchase;
import com.project.custom.PurchaseApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseApiRepository extends JpaRepository<Purchase, Long>, PurchaseApiRepositoryCustom {
}
