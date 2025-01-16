package com.tfprojarq.tfprojarq.adapters.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.ApplicationJpaEntity;
import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;

@Component
public class ApplicationMapper {
    public static ApplicationJpaEntity toJpaEntity(ApplicationEntity application) {
        ApplicationJpaEntity jpaEntity = new ApplicationJpaEntity();
        jpaEntity.setId(application.getId());
        jpaEntity.setName(application.getName());
        jpaEntity.setMonthlyCost(application.getMonthlyCost());
        return jpaEntity;
    }

    public static ApplicationEntity toDomainEntity(ApplicationJpaEntity jpaEntity) {
        return new ApplicationEntity(
            jpaEntity.getId(),
            jpaEntity.getName(),
            jpaEntity.getMonthlyCost()
        );
    }

    public static List<ApplicationEntity> toDomainEntities(List<ApplicationJpaEntity> applicationJpaEntities) {
        return applicationJpaEntities.stream()
                .map(ApplicationMapper::toDomainEntity)
                .collect(Collectors.toList());
    }
}
