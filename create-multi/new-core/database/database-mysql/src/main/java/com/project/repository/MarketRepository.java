package com.project.repository;

import com.project.Market;
import com.project.custom.MarketRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends JpaRepository<Market, Long>, MarketRepositoryCustom {
}
