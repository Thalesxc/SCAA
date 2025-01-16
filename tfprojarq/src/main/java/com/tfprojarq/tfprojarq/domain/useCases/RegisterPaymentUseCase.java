package com.tfprojarq.tfprojarq.domain.useCases;

import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;

public interface RegisterPaymentUseCase {
    PaymentEntity registerPayment(Long subscriptionId, double amountPaid, int day, int month, int year);
}
