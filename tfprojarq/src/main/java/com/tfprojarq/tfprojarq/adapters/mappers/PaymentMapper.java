package com.tfprojarq.tfprojarq.adapters.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.PaymentJpaEntity;
import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;

@Component
public class PaymentMapper {
    public static PaymentJpaEntity toJpaEntity(PaymentEntity payment) {
        PaymentJpaEntity jpaEntity = new PaymentJpaEntity();
        jpaEntity.setId(payment.getId());
        jpaEntity.setSubscription(SubscriptionMapper.toJpaEntity(payment.getSubscription()));
        jpaEntity.setAmountPaid(payment.getAmountPaid());
        jpaEntity.setPaymentDate(payment.getPaymentDate());
        return jpaEntity;
    }

    public static PaymentEntity toDomainEntity(PaymentJpaEntity jpaEntity) {
        return new PaymentEntity(
            jpaEntity.getId(),
            SubscriptionMapper.toDomainEntity(jpaEntity.getSubscription()),
            jpaEntity.getAmountPaid(),
            jpaEntity.getPaymentDate()
        );
    }

    public static List<PaymentEntity> toDomainEntities(List<PaymentJpaEntity> paymentJpaEntities) {
        return paymentJpaEntities.stream()
                .map(PaymentMapper::toDomainEntity)
                .collect(Collectors.toList());
    }
}
