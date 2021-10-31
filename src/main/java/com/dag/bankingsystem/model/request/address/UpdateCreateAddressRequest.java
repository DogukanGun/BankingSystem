package com.dag.bankingsystem.model.request.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCreateAddressRequest {


    private String city;

    private String district;

    private String neighbourhood;

    private String buildingNumber;

    private String flatNumber;

}
