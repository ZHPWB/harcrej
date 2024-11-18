package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "choragiew")
@Data
public class ChoragiewEntity {

    @GeneratedValue
    @Id
    private int choragiewId;
    private CountryEntity country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "komendant_choragwi_id")
    private PersonEntity komendantChoragwi;
    @OneToMany(mappedBy = "choragiew", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HufiecEntity> hufce;
}
