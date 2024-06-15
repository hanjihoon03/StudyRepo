package com.repository;

import com.base.Market;
import com.custom.MarketApiRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketApiRepository extends JpaRepository<Market, Long>, MarketApiRepositoryCustom {
}
