package com.dag.bankingsystem.model.entity;


import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Target;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    private boolean isSold=false;

    private int amount;

    private int value;

    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",insertable = false,updatable = false,nullable = false)
    private Customer customer;

    @Column(name = "investment_id")
    private Integer investmentId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "investment_id",insertable = false,nullable = false,updatable = false)
    private Investment investment;

}
