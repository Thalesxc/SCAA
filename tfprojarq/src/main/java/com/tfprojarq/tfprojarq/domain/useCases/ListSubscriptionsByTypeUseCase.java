package com.tfprojarq.tfprojarq.domain.useCases;

import java.time.LocalDate;
import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

public interface ListSubscriptionsByTypeUseCase {
    List<SubscriptionEntity> listByType(String type);
    
    String getType(LocalDate startDate, LocalDate endDate);
}
