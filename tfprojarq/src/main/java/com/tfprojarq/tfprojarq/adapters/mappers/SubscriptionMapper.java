package com.tfprojarq.tfprojarq.adapters.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.SubscriptionJpaEntity;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;

@Component
public class SubscriptionMapper {
    public static SubscriptionJpaEntity toJpaEntity(SubscriptionEntity subscription) {
        SubscriptionJpaEntity jpaEntity = new SubscriptionJpaEntity();
        jpaEntity.setId(subscription.getId()); // Supondo que já exista um ID
        jpaEntity.setApplication(ApplicationMapper.toJpaEntity(subscription.getApplication()));
        jpaEntity.setCustomer(CustomerMapper.toJpaEntity(subscription.getCustomer()));
        jpaEntity.setStartDate(subscription.getStartDate());
        jpaEntity.setEndDate(subscription.getEndDate());
        return jpaEntity;
    }

    public static SubscriptionEntity toDomainEntity(SubscriptionJpaEntity jpaEntity) {
        return new SubscriptionEntity(
            jpaEntity.getId(),
            ApplicationMapper.toDomainEntity(jpaEntity.getApplication()),
            CustomerMapper.toDomainEntity(jpaEntity.getCustomer()),
            jpaEntity.getStartDate(),
            jpaEntity.getEndDate()
        );
    }

    public static List<SubscriptionEntity> toDomainEntities(List<SubscriptionJpaEntity> subscriptionJpaEntities) {
        return subscriptionJpaEntities.stream()
                .map(SubscriptionMapper::toDomainEntity)
                .collect(Collectors.toList());
    }
}
