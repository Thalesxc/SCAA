package com.tfprojarq.tfprojarq.adapters.repositoriesJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.SubscriptionJpaEntity;

public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionJpaEntity, Long> {

    @Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.endDate > CURRENT_DATE")
    List<SubscriptionJpaEntity> findActiveSubscriptions();

    @Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.endDate <= CURRENT_DATE")
    List<SubscriptionJpaEntity> findCancelledSubscriptions();

    List<SubscriptionJpaEntity> findByCustomerId(Long customerId);

    List<SubscriptionJpaEntity> findByApplicationId(Long applicationId);
}
