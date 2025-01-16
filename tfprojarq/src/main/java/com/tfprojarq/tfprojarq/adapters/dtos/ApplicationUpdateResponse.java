package com.tfprojarq.tfprojarq.adapters.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApplicationUpdateResponse {
    private Long appId;
    private String name;
    private double cost;

    public ApplicationUpdateResponse(Long appId, String name, double cost) {
        this.appId = appId;
        this.name = name;
        this.cost = cost;
    }
}
