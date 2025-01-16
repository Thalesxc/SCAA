package com.tfprojarq.tfprojarq.domain.repositories;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;

public interface ApplicationRepository {
    
    ApplicationEntity findById(Long id);
    
    ApplicationEntity save(ApplicationEntity application);
    
    List<ApplicationEntity> findAll();
}