package com.dag.bankingsystem.model.request.customer;


import com.dag.bankingsystem.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String name;

    private Date birthday;

    private Address address;

    private String phone;

    private String email;
}
