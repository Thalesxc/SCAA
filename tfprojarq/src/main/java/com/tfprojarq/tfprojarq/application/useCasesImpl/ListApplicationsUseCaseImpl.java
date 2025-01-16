package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;
import com.tfprojarq.tfprojarq.domain.repositories.ApplicationRepository;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationsUseCase;

public class ListApplicationsUseCaseImpl implements ListApplicationsUseCase {

    private final ApplicationRepository applicationRepository;

    public ListApplicationsUseCaseImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<ApplicationEntity> listAll() {
        return applicationRepository.findAll();
    }
}
