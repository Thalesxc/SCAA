package com.tfprojarq.tfprojarq.domain.repositories;

import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;

public interface PaymentRepository {
    
    PaymentEntity findById(Long id);
    
    PaymentEntity save(PaymentEntity payment);
}
