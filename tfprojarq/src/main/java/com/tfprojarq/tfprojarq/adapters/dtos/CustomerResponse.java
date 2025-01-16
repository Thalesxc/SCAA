package com.tfprojarq.tfprojarq.adapters.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter       
@Setter       
@ToString
public class CustomerResponse {
    private Long code;
    private String name;
    private String email;

    public CustomerResponse(Long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }
}
