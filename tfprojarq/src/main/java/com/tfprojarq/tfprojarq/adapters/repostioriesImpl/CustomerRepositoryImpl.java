package com.tfprojarq.tfprojarq.adapters.repostioriesImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.CustomerJpaEntity;
import com.tfprojarq.tfprojarq.adapters.mappers.CustomerMapper;
import com.tfprojarq.tfprojarq.adapters.repositoriesJPA.CustomerJpaRepository;
import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;
import com.tfprojarq.tfprojarq.domain.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public CustomerEntity findById(Long id) {
        CustomerJpaEntity customerJpaEntity = customerJpaRepository.findById(id).orElse(null);
        if (customerJpaEntity == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        return CustomerMapper.toDomainEntity(customerJpaEntity);
    }

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerJpaEntity> customerJpaEntities = customerJpaRepository.findAll();
        return CustomerMapper.toDomainEntities(customerJpaEntities);
    }
}