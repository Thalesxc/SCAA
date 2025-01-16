package com.tfprojarq.tfprojarq.domain.entities;

import java.time.LocalDate;

public class SubscriptionEntity {
    private Long id;
    private ApplicationEntity application;
    private CustomerEntity customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public SubscriptionEntity(Long id, ApplicationEntity application, CustomerEntity customer, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.application = application;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", application=" + application +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}