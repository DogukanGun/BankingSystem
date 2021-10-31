package com.dag.bankingsystem.model.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "addresses")
@SQLDelete(sql = "UPDATE addresses SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Address extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    private String district;

    private String neighbourhood;

    private String buildingNumber;

    private String flatNumber;

}
