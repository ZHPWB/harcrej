package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "choragiew")
@Data
public class ChoragiewEntity {

    @GeneratedValue
    @Id
    private int choragiewId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}