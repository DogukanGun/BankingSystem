package com.dag.bankingsystem.model.mapper;


import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.entity.Customer;
import com.dag.bankingsystem.model.request.customer.CreateCustomerRequest;
import com.dag.bankingsystem.model.request.customer.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto convertToCustomerDto(Customer customer);

    Customer createCustomer(CreateCustomerRequest createCustomerRequest);

    void updateCustomer(@MappingTarget Customer customer, UpdateCustomerRequest updateCustomerRequest);
}


