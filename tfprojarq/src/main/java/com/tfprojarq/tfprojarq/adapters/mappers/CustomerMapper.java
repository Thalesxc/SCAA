package com.tfprojarq.tfprojarq.adapters.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tfprojarq.tfprojarq.adapters.entitiesJPA.CustomerJpaEntity;
import com.tfprojarq.tfprojarq.domain.entities.CustomerEntity;

@Component
public class CustomerMapper {
    public static CustomerJpaEntity toJpaEntity(CustomerEntity customer) {
        CustomerJpaEntity jpaEntity = new CustomerJpaEntity();
        jpaEntity.setId(customer.getId());
        jpaEntity.setName(customer.getName());
        jpaEntity.setEmail(customer.getEmail());
        return jpaEntity;
    }

    public static CustomerEntity toDomainEntity(CustomerJpaEntity jpaEntity) {
        return new CustomerEntity(
            jpaEntity.getId(),
            jpaEntity.getName(),
            jpaEntity.getEmail()
        );
    }

    public static List<CustomerEntity> toDomainEntities(List<CustomerJpaEntity> customerJpaEntities) {
        return customerJpaEntities.stream()
                .map(CustomerMapper::toDomainEntity)
                .collect(Collectors.toList());
    }
}
