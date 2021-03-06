package com.dag.bankingsystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@SQLDelete(sql = "UPDATE transactions SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Transaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "source_account_id")
    private Integer sourceAccountId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "source_account_id",updatable = false,nullable = false,insertable = false)
    private Account sourceAccount;

    @Column(name = "target_account_id")
    private Integer targetAccountId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "target_account_id",updatable = false,nullable = false,insertable = false)
    private Account targetAccount;

    @Builder.Default
    private boolean isCanceled=false;

    private String currency;

    private Integer amount;


}
