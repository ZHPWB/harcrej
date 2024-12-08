package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hufiec")
@Data
public class HufiecEntity {

    @GeneratedValue
    @Id
    private int hufiecId;

    private String name;
    private String areaOfOperation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hufcowy_id")
    private UserEntity hufcowy;

    // This maps to the "hufiec" field in SzczepEntity
    @OneToMany(mappedBy = "hufiec", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SzczepEntity> szczepy;

    @ManyToOne
    @JoinColumn(name = "choragiew_id")
    private ChoragiewEntity choragiew;
}
