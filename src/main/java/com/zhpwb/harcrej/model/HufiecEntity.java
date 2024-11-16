package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hufiec")
@Data
public class HufiecEntity {

    @GeneratedValue
    @Id
    private int hufiecId;
    private String name;
    private String areaOfOperation;
    private String personInCharge;
}
