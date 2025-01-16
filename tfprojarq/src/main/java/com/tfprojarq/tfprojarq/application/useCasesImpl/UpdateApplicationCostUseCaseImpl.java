package com.tfprojarq.tfprojarq.application.useCasesImpl;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;
import com.tfprojarq.tfprojarq.domain.repositories.ApplicationRepository;
import com.tfprojarq.tfprojarq.domain.useCases.UpdateApplicationCostUseCase;

public class UpdateApplicationCostUseCaseImpl implements UpdateApplicationCostUseCase {

    private final ApplicationRepository applicationRepository;

    public UpdateApplicationCostUseCaseImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationEntity updateCost(Long applicationId, double newCost) {
        ApplicationEntity application = applicationRepository.findById(applicationId);
        if (application == null) {
            throw new IllegalArgumentException("Aplicativo não encontrado com o ID fornecido");
        }

        application.setMonthlyCost(newCost);
        ApplicationEntity updatedApplication = applicationRepository.save(application);

        return updatedApplication;
    }
}
