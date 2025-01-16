package com.tfprojarq.tfprojarq.adapters;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfprojarq.tfprojarq.adapters.dtos.ApplicationResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.ApplicationUpdateResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.CustomerResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.PaymentResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.SubscriptionListResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.SubscriptionResponse;
import com.tfprojarq.tfprojarq.adapters.dtos.SubscriptionStatusResponse;
import com.tfprojarq.tfprojarq.adapters.requests.PaymentRequest;
import com.tfprojarq.tfprojarq.adapters.requests.SubscriptionRequest;
import com.tfprojarq.tfprojarq.adapters.requests.UpdateCostRequest;
import com.tfprojarq.tfprojarq.domain.entities.ApplicationEntity;
import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;
import com.tfprojarq.tfprojarq.domain.entities.PaymentEntity;
import com.tfprojarq.tfprojarq.domain.entities.SubscriptionEntity;
import com.tfprojarq.tfprojarq.domain.useCases.CheckSubscriptionStatusUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.CreateSubscriptionUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationSubscriptionsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListApplicationsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomerSubscriptionsUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomersUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.ListSubscriptionsByTypeUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.RegisterPaymentUseCase;
import com.tfprojarq.tfprojarq.domain.useCases.UpdateApplicationCostUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/servcad")
@AllArgsConstructor
public class Controller {

    private final CheckSubscriptionStatusUseCase checkSubscriptionStatusUseCase;
    private final CreateSubscriptionUseCase createSubscriptionUseCase;
    private final UpdateApplicationCostUseCase updateApplicationCostUseCase;
    private final ListApplicationSubscriptionsUseCase listApplicationSubscriptionsUseCase;
    private final ListApplicationsUseCase listApplicationsUseCase;
    private final ListCustomerSubscriptionsUseCase listCustomerSubscriptionsUseCase;
    private final ListCustomersUseCase listCustomersUseCase;
    private final ListSubscriptionsByTypeUseCase listSubscriptionsByTypeUseCase;
    private final RegisterPaymentUseCase registerPaymentUseCase;


    @GetMapping("/clientes")
    public List<CustomerResponse> getAllcustomers() {
        List<CustomerEntity> customers = listCustomersUseCase.listAll();
        return customers.stream()
                      .map(customer -> new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail()))
                      .collect(Collectors.toList());
    }

    @GetMapping("/aplicativos")
    public List<ApplicationResponse> getAllApplications() {
        List<ApplicationEntity> apps = listApplicationsUseCase.listAll();
        return apps.stream()
                   .map(app -> new ApplicationResponse(app.getId(), app.getName(), app.getMonthlyCost()))
                   .collect(Collectors.toList());
    }

    @PostMapping("/assinaturas")
    public SubscriptionResponse createSubscription(@RequestBody SubscriptionRequest request) {
        SubscriptionEntity subscription = createSubscriptionUseCase.create(request.getCustomerId(), request.getAppId());
        return new SubscriptionResponse(subscription.getId(), subscription.getCustomer().getId(), subscription.getApplication().getId(),
                                        subscription.getStartDate(), subscription.getEndDate());
    }

    @PostMapping("/aplicativos/atualizacusto/{idAplicativo}")
    public ApplicationUpdateResponse updateAppCost(@PathVariable("idAplicativo") Long idAplicativo, @RequestBody UpdateCostRequest request) {
        ApplicationEntity updatedApp = updateApplicationCostUseCase.updateCost(idAplicativo, request.getCost());
        return new ApplicationUpdateResponse(updatedApp.getId(), updatedApp.getName(), updatedApp.getMonthlyCost());
    }
    

    @GetMapping("/assinaturas/{tipo}")
    public List<SubscriptionListResponse> getSubscriptionsByType(@PathVariable("tipo") String type) {
        List<SubscriptionEntity> subscriptions = listSubscriptionsByTypeUseCase.listByType(type);
        return subscriptions.stream()
                            .map(subscription -> new SubscriptionListResponse(subscription.getId(), subscription.getCustomer().getId(),
                                                                              subscription.getApplication().getId(), subscription.getStartDate(),
                                                                              subscription.getEndDate(), listSubscriptionsByTypeUseCase.getType(subscription.getStartDate()
                                                                            , subscription.getEndDate())))
                            .collect(Collectors.toList());
    }

    @GetMapping("/asscli/{codcli}")
    public List<SubscriptionListResponse> getSubscriptionsBycustomer(@PathVariable("codcli") Long customerId) {
        List<SubscriptionEntity> subscriptions = listCustomerSubscriptionsUseCase.listByCustomer(customerId);
        return subscriptions.stream()
                            .map(subscription -> new SubscriptionListResponse(subscription.getId(), subscription.getCustomer().getId(),
                                                                              subscription.getApplication().getId(), subscription.getStartDate(),
                                                                              subscription.getEndDate(), listSubscriptionsByTypeUseCase.getType(subscription.getStartDate()
                                                                              , subscription.getEndDate())))
                            .collect(Collectors.toList());
    }

    @GetMapping("/assapp/{codapp}")
    public List<SubscriptionListResponse> getSubscriptionsByApp(@PathVariable("codapp") Long codapp) {
        List<SubscriptionEntity> subscriptions = listApplicationSubscriptionsUseCase.listByApplication(codapp);
        return subscriptions.stream()
                            .map(subscription -> new SubscriptionListResponse(subscription.getId(), subscription.getCustomer().getId(),
                                                                              subscription.getApplication().getId(), subscription.getStartDate(),
                                                                              subscription.getEndDate(), 
                                                                              listSubscriptionsByTypeUseCase.getType(subscription.getStartDate(), 
                                                                              subscription.getEndDate())))
                            .collect(Collectors.toList());
    }

    @PostMapping("/registrarpagamento")
    public PaymentResponse registerPayment(@RequestBody PaymentRequest request) {
        PaymentEntity payment = registerPaymentUseCase.registerPayment(request.getSubId(), request.getAmountPaid(), request.getDay(), request.getMonth(), request.getYear());
        String status;
        Double refundedAmount = 0.0;
        if (payment == null) {
            status = "VALOR_INCORRETO";
            refundedAmount = request.getAmountPaid();
        } else {
            status = "PAGAMENTO_OK";
        }
        return new PaymentResponse(status, LocalDate.of(request.getYear(), request.getMonth(), request.getDay()), refundedAmount);
    }

    @GetMapping("/assinvalida/{codass}")
    public SubscriptionStatusResponse isSubscriptionValid(@PathVariable("codass") Long subscriptionId) {
        SubscriptionEntity subscription = checkSubscriptionStatusUseCase.isActive(subscriptionId); 
        return new SubscriptionStatusResponse(subscription.getId(), subscription.getEndDate());
    }
}