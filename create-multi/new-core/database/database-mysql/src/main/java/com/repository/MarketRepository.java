package com.repository;

import com.base.Market;
import com.custom.MarketRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends JpaRepository<Market, Long>, MarketRepositoryCustom {
}
