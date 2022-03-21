package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.CustomerEntity; 

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Integer> {

}
