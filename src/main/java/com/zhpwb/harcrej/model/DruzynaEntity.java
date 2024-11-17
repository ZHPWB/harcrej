package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "druzyna")
@Data
public class DruzynaEntity {

    @GeneratedValue
    @Id
    private int druzynaId;
    private int szczepId;
    private String name;
    @Embedded
    private Address addressOfOperation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "druzynowy_id")
    private PersonEntity druzynowy;
    private String type;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PersonEntity> komenda;
    @Embedded
    private StatsDto currentStats;
    private String yearEstablished;
}
