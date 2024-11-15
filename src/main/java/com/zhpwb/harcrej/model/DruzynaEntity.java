package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "druzyna")
@Data
public class DruzynaEntity {

    @GeneratedValue
    @Id
    private int druzynaId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}
