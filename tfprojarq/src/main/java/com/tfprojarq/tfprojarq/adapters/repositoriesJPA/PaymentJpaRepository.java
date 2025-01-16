package com.tfprojarq.tfprojarq.adapters.repositoriesJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.PaymentJpaEntity;

public interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, Long> {
}
