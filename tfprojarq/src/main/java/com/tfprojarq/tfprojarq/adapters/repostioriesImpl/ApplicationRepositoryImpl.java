package com.tfprojarq.tfprojarq.adapters.repostioriesImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.ApplicationJpaEntity;
import com.tfprojarq.tfprojarq.adapters.mappers.ApplicationMapper;
import com.tfprojarq.tfprojarq.adapters.repositoriesJPA.ApplicationJpaRepository;
import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;
import com.tfprojarq.tfprojarq.domain.repositories.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final ApplicationJpaRepository applicationJpaRepository;

    @Override
    public ApplicationEntity findById(Long id) {
        ApplicationJpaEntity applicationJpaEntity = applicationJpaRepository.findById(id).orElse(null);
        if (applicationJpaEntity == null) {
            throw new IllegalArgumentException("Application not found");
        }
        return ApplicationMapper.toDomainEntity(applicationJpaEntity);
    }

    @Override
    public ApplicationEntity save(ApplicationEntity application) {
        ApplicationJpaEntity applicationJpaEntity = ApplicationMapper.toJpaEntity(application);
        applicationJpaEntity = applicationJpaRepository.save(applicationJpaEntity);
        return ApplicationMapper.toDomainEntity(applicationJpaEntity);
    }

    @Override
    public List<ApplicationEntity> findAll() {
        List<ApplicationJpaEntity> applicationJpaEntities = applicationJpaRepository.findAll();
        return ApplicationMapper.toDomainEntities(applicationJpaEntities);
    }
}
