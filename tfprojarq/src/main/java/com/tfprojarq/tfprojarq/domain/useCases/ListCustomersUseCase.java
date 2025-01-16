package com.tfprojarq.tfprojarq.domain.useCases;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;

public interface ListCustomersUseCase {
    List<CustomerEntity> listAll();
}
