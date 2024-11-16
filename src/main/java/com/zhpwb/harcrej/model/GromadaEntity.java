package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "gromada")
@Data
public class GromadaEntity {

    @GeneratedValue
    @Id
    private int gromadaId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}
