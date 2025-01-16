package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.time.LocalDate;

import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;
import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.repositories.ApplicationRepository;
import com.tfprojarq.tfprojarq.domain.repositories.CustomerRepository;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.CreateSubscriptionUseCase;

public class CreateSubscriptionUseCaseImpl implements CreateSubscriptionUseCase {

    private final SubscriptionRepository subscriptionRepository;
    private final ApplicationRepository applicationRepository;
    private final CustomerRepository customerRepository;

    public CreateSubscriptionUseCaseImpl(SubscriptionRepository subscriptionRepository, 
    ApplicationRepository applicationRepository, CustomerRepository customerRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public SubscriptionEntity create(Long customerId, Long applicationId) {
        CustomerEntity customer = customerRepository.findById(customerId);
        ApplicationEntity application = applicationRepository.findById(applicationId);
    
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

        Long subscriptionId = null;

        SubscriptionEntity subscription = new SubscriptionEntity(subscriptionId, application, customer, startDate, endDate);

        return subscriptionRepository.save(subscription);
    }
}
