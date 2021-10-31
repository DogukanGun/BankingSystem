package com.dag.bankingsystem.repository;

import com.dag.bankingsystem.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
