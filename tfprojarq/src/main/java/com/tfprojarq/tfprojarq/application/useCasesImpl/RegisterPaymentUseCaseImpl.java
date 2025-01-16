package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionUpdate;
import com.tfprojarq.tfprojarq.domain.repositories.PaymentRepository;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.CheckSubscriptionStatusUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.RegisterPaymentUseCase;

public class RegisterPaymentUseCaseImpl implements RegisterPaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final CheckSubscriptionStatusUseCase checkSubscriptionStatusUseCase;
    private final RabbitTemplate rabbitTemplate;

    public RegisterPaymentUseCaseImpl(
            PaymentRepository paymentRepository,
            SubscriptionRepository subscriptionRepository,
            CheckSubscriptionStatusUseCase checkSubscriptionStatusUseCase,
            RabbitTemplate rabbitTemplate) {
        this.paymentRepository = paymentRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.checkSubscriptionStatusUseCase = checkSubscriptionStatusUseCase;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public PaymentEntity registerPayment(Long subscriptionId, double amountPaid, int day, int month, int year) {
        SubscriptionEntity subscription = subscriptionRepository.findById(subscriptionId);

        if (subscription.getApplication().getMonthlyCost() != amountPaid) {
            return null;
        }

        LocalDate paymentDate = LocalDate.of(year, month, day);

        boolean isActive = paymentDate.isBefore(subscription.getEndDate());
        LocalDate newEndDate;

        if (!isActive) {
            newEndDate = paymentDate.plusDays(30); 
        } else {
            newEndDate = subscription.getEndDate().plusDays(30); 
        }

        subscription.setEndDate(newEndDate);
        subscriptionRepository.save(subscription);

        rabbitTemplate.convertAndSend("subscription.exchange.update.cache", "", new SubscriptionUpdate(subscription.getId(), subscription.getEndDate()));

        Long paymentId = null;

        PaymentEntity payment = new PaymentEntity(paymentId, subscription, amountPaid, paymentDate);
        return paymentRepository.save(payment);
    }
}
