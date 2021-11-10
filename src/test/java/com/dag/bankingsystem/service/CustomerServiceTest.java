package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.entity.Customer;
import com.dag.bankingsystem.model.request.customer.CreateCustomerRequest;
import com.dag.bankingsystem.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService sut;

    @Mock
    private CustomerRepository customerRepository;

    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;

    private CustomerDto customerDto;

    private CreateCustomerRequest createCustomerRequest;

    @BeforeEach
    void setup(){
        customerDto = CustomerDto.builder()
                .id(1)
                .name("test")
                .email("test@test.com")
                .build();

        createCustomerRequest = CreateCustomerRequest.builder()
                .name("test")
                .email("test@test.com")
                .build();
    }

    @Test
    void it_should_return_expected_customer(){
        //Given
        when(customerRepository.save(customerArgumentCaptor.capture())).thenReturn(Customer.builder()
                .id(1)
                .name("test")
                .email("test@test.com")
                .build());

        //When
        CustomerDto customerDtoFromRepo = sut.createCustomer(createCustomerRequest);


        //Then
        Assertions.assertEquals(customerDto,customerDtoFromRepo);
        Customer customer = customerArgumentCaptor.getValue();
        Assertions.assertEquals(customer.getName(),"test");
        Assertions.assertEquals(customer.getEmail(),"test@test.com");
    }
}
