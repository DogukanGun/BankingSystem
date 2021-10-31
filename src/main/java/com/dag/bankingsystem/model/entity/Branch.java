package com.dag.bankingsystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "branches")
@SQLDelete(sql = "UPDATE branches SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Branch extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "address_id")
    private Integer addressId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",updatable = false,nullable = false,insertable = false)
    private Address address;

    // TODO: 31.10.2021 Calisanlar ekle buraya

}
