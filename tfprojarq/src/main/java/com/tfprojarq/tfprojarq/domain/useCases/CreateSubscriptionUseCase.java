package com.tfprojarq.tfprojarq.domain.useCases;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

public interface CreateSubscriptionUseCase {
    SubscriptionEntity create(Long customerId, Long applicationId);
}