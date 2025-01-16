package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomerSubscriptionsUseCase;

public class ListCustomerSubscriptionsUseCaseImpl implements ListCustomerSubscriptionsUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public ListCustomerSubscriptionsUseCaseImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<SubscriptionEntity> listByCustomer(Long customerId) {
        return subscriptionRepository.findByCustomerId(customerId);
    }
}
