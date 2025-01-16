package com.tfprojarq.tfprojarq.domain.useCases;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

public interface ListApplicationSubscriptionsUseCase {
    List<SubscriptionEntity> listByApplication(Long applicationId);
}
