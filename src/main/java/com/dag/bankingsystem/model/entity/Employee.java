package com.dag.bankingsystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "employees")
@SQLDelete(sql = "UPDATE employees SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Column(name = "branch_id")
    private Integer branchId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id",updatable = false,nullable = false,insertable = false)
    private Branch branch;

    @Column(name = "account_id")
    private Integer accountId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",insertable = false,nullable = false,updatable = false)
    private Account salaryAccount;

    @Builder.Default
    private boolean isFired=false;



}
