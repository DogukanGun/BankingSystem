package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.entity.Customer;
import com.dag.bankingsystem.model.request.customer.CreateCustomerRequest;
import com.dag.bankingsystem.model.request.customer.UpdateCustomerRequest;
import com.dag.bankingsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.dag.bankingsystem.model.mapper.CreditMapper.CREDIT_MAPPER;
import static com.dag.bankingsystem.model.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.dag.bankingsystem.model.mapper.StockMapper.STOCK_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CreditDto> getCredits(int id){
        Customer customer = getCustomerById(id);
        return CREDIT_MAPPER.convertToCreditDtoList(customer.getCredits());
    }

    public List<StockDto> getStocks(int id){
        Customer customer = getCustomerById(id);
        return STOCK_MAPPER.convertToStockDtoList(customer.getStocks());
    }
    public CustomerDto createCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = CUSTOMER_MAPPER.createCustomer(createCustomerRequest);
        return CUSTOMER_MAPPER.convertToCustomerDto(customerRepository.save(customer));
    }

    public CustomerDto updateCustomer(int id,UpdateCustomerRequest updateCustomerRequest){
        Customer customer = getCustomerById(id);
        CUSTOMER_MAPPER.updateCustomer(customer,updateCustomerRequest);
        return CUSTOMER_MAPPER.convertToCustomerDto(customerRepository.save(customer));
    }

    private Customer getCustomerById(int id){
        return customerRepository.findById(id).orElseThrow(()->new NotFoundException("Customer is not exists"));
    }

    public CustomerDto getCustomer(int id){
        return CUSTOMER_MAPPER.convertToCustomerDto(getCustomerById(id));
    }

    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }
}
