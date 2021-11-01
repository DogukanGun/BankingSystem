package com.dag.bankingsystem.model.request.stock;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStockRequest {


    private int amount;

    private int value;

    private boolean isSold;
}
