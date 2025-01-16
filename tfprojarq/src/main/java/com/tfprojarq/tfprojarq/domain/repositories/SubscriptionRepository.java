package com.tfprojarq.tfprojarq.domain.repositories;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

public interface SubscriptionRepository {
    
    SubscriptionEntity save(SubscriptionEntity subscription);
    
    List<SubscriptionEntity> findActiveSubscriptions();
    
    List<SubscriptionEntity> findCancelledSubscriptions();
    
    List<SubscriptionEntity> findByCustomerId(Long customerId);
    
    List<SubscriptionEntity> findByApplicationId(Long applicationId);
    
    List<SubscriptionEntity> findAll();

    SubscriptionEntity findById(Long id);
}