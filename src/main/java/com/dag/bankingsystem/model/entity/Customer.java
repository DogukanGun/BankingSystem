package com.dag.bankingsystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customers SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date birthday;

    @Column(name = "address_id")
    private Integer addressId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",nullable = false,insertable = false,updatable = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Account> accounts;

    private String phone;

    private String email;
}
