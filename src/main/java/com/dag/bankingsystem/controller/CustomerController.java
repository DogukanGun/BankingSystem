package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.request.customer.CreateCustomerRequest;
import com.dag.bankingsystem.model.request.customer.UpdateCustomerRequest;
import com.dag.bankingsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public CustomerDto getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping("{id}")
    public CustomerDto updateCustomer(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateCustomer(id,updateCustomerRequest);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
    }
}
