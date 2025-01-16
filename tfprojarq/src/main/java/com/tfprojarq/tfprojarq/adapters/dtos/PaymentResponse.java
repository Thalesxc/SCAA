package com.tfprojarq.tfprojarq.adapters.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentResponse {
    private String status;
    private LocalDate paymentDate;
    private double refundedAmount;

    public PaymentResponse(String status, LocalDate paymentDate, double refundedAmount) {
        this.status = status;
        this.paymentDate = paymentDate;
        this.refundedAmount = refundedAmount;
    }
}