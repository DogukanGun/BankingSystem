package com.dag.bankingsystem.model.request.investment;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCreateInvestmentRequest {
    private String name;

    private String explanation;

    private int fund;

}
