package com.tfprojarq.tfprojarq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tfprojarq.tfprojarq.application.useCasesImpl.CheckSubscriptionStatusUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.CreateSubscriptionUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.ListApplicationSubscriptionsUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.ListApplicationsUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.ListCustomerSubscriptionsUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.ListCustomersUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.ListSubscriptionsByTypeUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.RegisterPaymentUseCaseImpl;
import com.tfprojarq.tfprojarq.application.useCasesImpl.UpdateApplicationCostUseCaseImpl;
import com.tfprojarq.tfprojarq.domain.repositories.ApplicationRepository;
import com.tfprojarq.tfprojarq.domain.repositories.CustomerRepository;
import com.tfprojarq.tfprojarq.domain.repositories.PaymentRepository;
import com.tfprojarq.tfprojarq.domain.repositories.SubscriptionRepository;
import com.tfprojarq.tfprojarq.domain.useCases.CheckSubscriptionStatusUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.CreateSubscriptionUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationSubscriptionsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomerSubscriptionsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomersUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListSubscriptionsByTypeUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.RegisterPaymentUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.UpdateApplicationCostUseCase;

@Configuration
public class UseCaseConfig {

    @Bean
    public CheckSubscriptionStatusUseCase checkSubscriptionStatusUseCase(SubscriptionRepository subscriptionRepository) {
        return new CheckSubscriptionStatusUseCaseImpl(subscriptionRepository);
    }

    @Bean
    public CreateSubscriptionUseCase createSubscriptionUseCase(SubscriptionRepository subscriptionRepository,
                                                               ApplicationRepository applicationRepository,
                                                               CustomerRepository customerRepository) {
        return new CreateSubscriptionUseCaseImpl(subscriptionRepository, applicationRepository, customerRepository);
    }

    @Bean
    public ListApplicationSubscriptionsUseCase listApplicationSubscriptionsUseCase(SubscriptionRepository subscriptionRepository) {
        return new ListApplicationSubscriptionsUseCaseImpl(subscriptionRepository);
    }

    @Bean
    public ListApplicationsUseCase listApplicationsUseCase(ApplicationRepository applicationRepository) {
        return new ListApplicationsUseCaseImpl(applicationRepository);
    }

    @Bean
    public ListCustomerSubscriptionsUseCase listCustomerSubscriptionsUseCase(SubscriptionRepository subscriptionRepository) {
        return new ListCustomerSubscriptionsUseCaseImpl(subscriptionRepository);
    }

    @Bean
    public ListCustomersUseCase listCustomersUseCase(CustomerRepository customerRepository) {
        return new ListCustomersUseCaseImpl(customerRepository);
    }

    @Bean
    public ListSubscriptionsByTypeUseCase listSubscriptionsByTypeUseCase(SubscriptionRepository subscriptionRepository) {
        return new ListSubscriptionsByTypeUseCaseImpl(subscriptionRepository);
    }

    @Bean
    public RegisterPaymentUseCase registerPaymentUseCase(
            PaymentRepository paymentRepository,
            SubscriptionRepository subscriptionRepository,
            CheckSubscriptionStatusUseCase checkSubscriptionStatusUseCase,
            RabbitTemplate rabbitTemplate) {
        return new RegisterPaymentUseCaseImpl(paymentRepository, subscriptionRepository,
         checkSubscriptionStatusUseCase, rabbitTemplate);
    }

    @Bean
    public UpdateApplicationCostUseCase updateApplicationCostUseCase(ApplicationRepository applicationRepository) {
        return new UpdateApplicationCostUseCaseImpl(applicationRepository);
    }
}
