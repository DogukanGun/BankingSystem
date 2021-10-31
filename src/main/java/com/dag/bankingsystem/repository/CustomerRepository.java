package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
