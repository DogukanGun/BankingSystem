package com.dag.bankingsystem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.StringTokenizer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvestmentDto {

        private String name;

        private String explanation;

        private int fund;
}
