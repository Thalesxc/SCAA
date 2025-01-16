package com.tfprojarq.tfprojarq.adapters.repositoriesJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.CustomerJpaEntity;



public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long> {
}