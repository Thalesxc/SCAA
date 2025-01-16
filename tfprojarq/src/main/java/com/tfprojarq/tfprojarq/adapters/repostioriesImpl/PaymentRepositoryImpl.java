package com.tfprojarq.tfprojarq.adapters.repostioriesImpl;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.PaymentJpaEntity;
import com.tfprojarq.tfprojarq.adapters.mappers.PaymentMapper;
import com.tfprojarq.tfprojarq.adapters.repositoriesJPA.PaymentJpaRepository;
import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;
import com.tfprojarq.tfprojarq.domain.repositories.PaymentRepository;

import lombok.RequiredArgsConstructor;
    
@Component
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public PaymentEntity save(PaymentEntity payment) {
        PaymentJpaEntity paymentJpaEntity = PaymentMapper.toJpaEntity(payment);
        paymentJpaEntity = paymentJpaRepository.save(paymentJpaEntity);
        return PaymentMapper.toDomainEntity(paymentJpaEntity);
    }

    @Override
    public PaymentEntity findById(Long id) {
        PaymentJpaEntity paymentJpaEntity = paymentJpaRepository.findById(id).orElse(null);
        return PaymentMapper.toDomainEntity(paymentJpaEntity);
    }
}
