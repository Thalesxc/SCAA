package com.tfprojarq.tfprojarq.domain.repositories;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;

public interface CustomerRepository {
    
    CustomerEntity findById(Long id);
    
    List<CustomerEntity> findAll();
}