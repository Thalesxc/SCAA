package com.tfprojarq.tfprojarq.adapters.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriptionRequest {
    private Long customerId;
    private Long appId;
}
