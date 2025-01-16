package com.tfprojarq.tfprojarq.domain.useCases;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

public interface CheckSubscriptionStatusUseCase {
    SubscriptionEntity isActive(Long subscriptionId);
}