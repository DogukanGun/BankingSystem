package com.dag.bankingsystem.model.request.customer;


import com.dag.bankingsystem.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotBlank
    @NotNull
    private String name;

    private Date birthday;

    @NotNull
    @Min(0)
    private Integer addressId;

    @NotBlank
    @NotNull
    private String phone;

    @NotBlank
    @NotNull
    private String email;
}
