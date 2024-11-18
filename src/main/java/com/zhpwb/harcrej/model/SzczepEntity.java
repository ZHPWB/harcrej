package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "szczep")
@Data
public class SzczepEntity {

    @GeneratedValue
    @Id
    private int szczepId;
    private String name;
    private String areaOfOperation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "szczepowy_id")
    private PersonEntity szczepowy;
    @OneToMany(mappedBy = "szczep")
    private List<DruzynaEntity> druzyny;
    @ManyToOne
    @JoinColumn(name = "hufiec_id")
    private HufiecEntity hufiec;
}
