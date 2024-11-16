package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "szczep")
@Data
public class SzczepEntity {

    @GeneratedValue
    @Id
    private int szczepId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}
