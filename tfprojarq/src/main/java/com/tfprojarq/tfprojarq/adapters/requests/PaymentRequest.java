package com.tfprojarq.tfprojarq.adapters.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {
    private int day;
    private int month;
    private int year;
    private Long subId;
    private double amountPaid;
}
