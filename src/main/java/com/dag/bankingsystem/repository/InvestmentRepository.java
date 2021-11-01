package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment,Integer> {
}
