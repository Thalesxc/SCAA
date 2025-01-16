package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.time.LocalDate;
import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.ListSubscriptionsByTypeUseCase;

public class ListSubscriptionsByTypeUseCaseImpl implements ListSubscriptionsByTypeUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public ListSubscriptionsByTypeUseCaseImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<SubscriptionEntity> listByType(String type) {
        if ("ATIVAS".equalsIgnoreCase(type)) {
            return subscriptionRepository.findActiveSubscriptions();
        } else if ("CANCELADAS".equalsIgnoreCase(type)) {
            return subscriptionRepository.findCancelledSubscriptions();
        }
        return subscriptionRepository.findAll();
    }

    @Override
    public String getType(LocalDate startDate, LocalDate endDate) {
        if (endDate.isAfter(LocalDate.now())) {
            return "ATIVA";
        } else {
            return "CANCELADA";
        }
    }
}
