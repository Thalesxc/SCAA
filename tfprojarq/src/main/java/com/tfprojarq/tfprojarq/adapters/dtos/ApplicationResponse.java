package com.tfprojarq.tfprojarq.adapters.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApplicationResponse {
    private Long code;
    private String name;
    private double cost;

    public ApplicationResponse(Long code, String name, double cost) {
        this.code = code;
        this.name = name;
        this.cost = cost;
    }

}