package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditRepository extends JpaRepository<Credit,Integer> {
}
