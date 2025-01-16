package com.tfprojarq.tfprojarq.adapters.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubscriptionResponse {
    private Long subscriptionId;
    private Long clientId;
    private Long appId;
    private LocalDate startDate;
    private LocalDate endDate;

    public SubscriptionResponse(Long subscriptionId, Long clientId, Long appId, LocalDate startDate, LocalDate endDate) {
        this.subscriptionId = subscriptionId;
        this.clientId = clientId;
        this.appId = appId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}