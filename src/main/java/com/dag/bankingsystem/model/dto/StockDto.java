package com.dag.bankingsystem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {

    private boolean isSold;

    private int amount;

    private int value;

    private String customerName;
}
