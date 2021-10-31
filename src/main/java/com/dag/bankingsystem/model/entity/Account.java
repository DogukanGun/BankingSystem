package com.dag.bankingsystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@SuperBuilder
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",insertable = false,nullable = false,updatable = false)
    private Customer customer;

    @Builder.Default
    private int balance = 0;

    private String currency;

    private String name;
    // TODO: 31.10.2021 Iban yaratici lazim
    private String iban;

    @Column(name = "branch_id")
    private Integer branchId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id",updatable = false,insertable = false,nullable = false)
    private Branch branch;

    private String accountType;

    @Column(name = "transaction_id")
    private Integer transactionId;

    // TODO: 30.10.2021 buraya transaction ile baglanti kurulacak

}
