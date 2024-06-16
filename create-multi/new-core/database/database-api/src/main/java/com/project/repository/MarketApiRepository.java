package com.project.repository;

import com.project.Market;
import com.project.custom.MarketApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketApiRepository extends JpaRepository<Market, Long>, MarketApiRepositoryCustom {
}
