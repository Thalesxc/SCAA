package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.time.LocalDate;
import java.util.concurrent.Flow;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.CheckSubscriptionStatusUseCase;


public class CheckSubscriptionStatusUseCaseImpl implements CheckSubscriptionStatusUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public CheckSubscriptionStatusUseCaseImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public SubscriptionEntity isActive(Long subscriptionId) {
        SubscriptionEntity subscription = subscriptionRepository.findById(subscriptionId);
        return subscription;
    }
}