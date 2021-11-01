package com.dag.bankingsystem.model.request.stock;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStockRequest {

    private int amount;

    private int value;

    private Integer customerId;
}
