package com.tfprojarq.tfprojarq.domain.useCases;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;

public interface UpdateApplicationCostUseCase {
    ApplicationEntity updateCost(Long applicationId, double newCost);
}