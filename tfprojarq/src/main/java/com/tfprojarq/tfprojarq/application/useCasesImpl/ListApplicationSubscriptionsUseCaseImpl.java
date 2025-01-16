package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationSubscriptionsUseCase;

public class ListApplicationSubscriptionsUseCaseImpl implements ListApplicationSubscriptionsUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public ListApplicationSubscriptionsUseCaseImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<SubscriptionEntity> listByApplication(Long applicationId) {
        return subscriptionRepository.findByApplicationId(applicationId);
    }
}