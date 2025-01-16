package com.tfprojarq.tfprojarq.adapters.repostioriesImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.SubscriptionJpaEntity;
import com.tfprojarq.tfprojarq.adapters.mappers.SubscriptionMapper;
import com.tfprojarq.tfprojarq.adapters.repositoriesJPA.SubscriptionJpaRepository;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final SubscriptionJpaRepository subscriptionJpaRepository;

    @Override
    public SubscriptionEntity save(SubscriptionEntity subscription) {
        SubscriptionJpaEntity subscriptionJpa = SubscriptionMapper.toJpaEntity(subscription);
        subscriptionJpa = subscriptionJpaRepository.save(subscriptionJpa);
        return SubscriptionMapper.toDomainEntity(subscriptionJpa);
    }

    @Override
    public List<SubscriptionEntity> findActiveSubscriptions() {
        List<SubscriptionJpaEntity> subscriptionJpa = subscriptionJpaRepository.findActiveSubscriptions();
        return SubscriptionMapper.toDomainEntities(subscriptionJpa);
    }

    @Override
    public List<SubscriptionEntity> findCancelledSubscriptions() {
        List<SubscriptionJpaEntity> subscriptionJpa = subscriptionJpaRepository.findCancelledSubscriptions();
        return SubscriptionMapper.toDomainEntities(subscriptionJpa);
    }

    @Override
    public List<SubscriptionEntity> findByCustomerId(Long customerId) {
        List<SubscriptionJpaEntity> subscriptionJpa = subscriptionJpaRepository.findByCustomerId(customerId);
        return SubscriptionMapper.toDomainEntities(subscriptionJpa);
    }

    @Override
    public List<SubscriptionEntity> findByApplicationId(Long applicationId) {
        List<SubscriptionJpaEntity> subscriptionJpa = subscriptionJpaRepository.findByApplicationId(applicationId);
        return SubscriptionMapper.toDomainEntities(subscriptionJpa);
    }

    @Override
    public List<SubscriptionEntity> findAll() {
        List<SubscriptionJpaEntity> subscriptionJpa = subscriptionJpaRepository.findAll();
        return SubscriptionMapper.toDomainEntities(subscriptionJpa);
    }

    @Override
    public SubscriptionEntity findById(Long id) {
        SubscriptionJpaEntity subscriptionJpa = subscriptionJpaRepository.findById(id).orElse(null);
        if (subscriptionJpa == null) {
            throw new IllegalArgumentException("Subscription not found");
        }
        return SubscriptionMapper.toDomainEntity(subscriptionJpa);
    }
}
