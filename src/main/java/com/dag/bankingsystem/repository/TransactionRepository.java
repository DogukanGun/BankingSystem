package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
