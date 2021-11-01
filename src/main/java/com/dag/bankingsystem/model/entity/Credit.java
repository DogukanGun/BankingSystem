package com.dag.bankingsystem.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "credits")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@SQLDelete(sql = "UPDATE accounts SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Credit extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int instalmentCount;

    private Integer money;

    private Integer interestRate;

    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false,insertable = false,updatable = false)
    private Customer customer;

    @Column(name = "branch_id")
    private Integer branchId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id",updatable = false,insertable = false,nullable = false)
    private Branch branch;

}
