package com.tfprojarq.tfprojarq.application.useCasesImpl;

import java.util.List;

import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;
import com.tfprojarq.tfprojarq.domain.repositories.CustomerRepository;
import com.tfprojarq.tfprojarq.domain.useCases.ListCustomersUseCase;

public class ListCustomersUseCaseImpl implements ListCustomersUseCase {

    private final CustomerRepository customerRepository;

    public ListCustomersUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerEntity> listAll() {
        return customerRepository.findAll();
    }
}
