package com.dag.bankingsystem.outsource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {
    public String cc;
    public String symbol;
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return cc.equals(currency.cc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cc);
    }
}
