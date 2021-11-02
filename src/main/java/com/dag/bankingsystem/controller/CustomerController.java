package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.request.customer.CreateCustomerRequest;
import com.dag.bankingsystem.model.request.customer.UpdateCustomerRequest;
import com.dag.bankingsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public CustomerDto getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @GetMapping("{id}/credits")
    public List<CreditDto> getCredits(@PathVariable int id){
        return customerService.getCredits(id);
    }

    @GetMapping("{id}/stocks")
    public List<StockDto> getStocks(@PathVariable int id){
        return customerService.getStocks(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@Valid  @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping("{id}")
    public CustomerDto updateCustomer(@PathVariable int id,@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateCustomer(id,updateCustomerRequest);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
    }
}
