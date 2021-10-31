package com.dag.bankingsystem.model.request.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCreateAddressRequest {


    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
    private String district;

    @NotBlank
    @NotNull
    private String neighbourhood;

    @NotBlank
    @NotNull
    private String buildingNumber;

    @NotBlank
    @NotNull
    private String flatNumber;

}
