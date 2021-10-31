package com.dag.bankingsystem.model.request.customer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotBlank
    @NotNull
    private String phone;

    @NotBlank
    @NotNull
    private String email;
}
