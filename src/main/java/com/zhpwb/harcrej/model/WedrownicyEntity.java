package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "wedrownicy")
@Data
public class WedrownicyEntity {

    @GeneratedValue
    @Id
    private int wedrownicyId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}
