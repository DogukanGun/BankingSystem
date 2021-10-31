package com.dag.bankingsystem.model.dto;


import com.dag.bankingsystem.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;

    private String name;

    private Date birthday;

    private AddressDto address;

    private String phone;

    private String email;
}
