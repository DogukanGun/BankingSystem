package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    Stock findByCustomerId(int customerId);
}
