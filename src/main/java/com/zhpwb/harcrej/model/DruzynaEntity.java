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

    // Foreign Key
    @ManyToOne
    @JoinColumn(name = "szczep_id")
    private SzczepEntity szczep;

    private String name;
    @Embedded
    private Address addressOfOperation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "druzynowy_id")  // Foreign key for PersonEntity (druzynowy)
    private PersonEntity druzynowy;
    private TypeDto type;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PersonEntity> komenda;
    @Embedded
    private StatsDto currentStats;
    private String yearEstablished;

}
