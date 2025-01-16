package com.tfprojarq.tfprojarq.adapters.repositoriesJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.ApplicationJpaEntity;

public interface ApplicationJpaRepository extends JpaRepository<ApplicationJpaEntity, Long> {
}
