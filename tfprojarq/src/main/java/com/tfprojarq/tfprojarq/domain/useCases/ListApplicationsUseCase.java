package com.tfprojarq.tfprojarq.domain.useCases;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;

public interface ListApplicationsUseCase {
    List<ApplicationEntity> listAll();
}
