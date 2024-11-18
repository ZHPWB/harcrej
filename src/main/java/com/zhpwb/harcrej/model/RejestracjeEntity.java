package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rejestracje")
@Data
public class RejestracjeEntity {

    @Id
    @GeneratedValue
    private int registrationId;

    private Integer druzynaId;

    private Integer szczepId;

    private Integer hufiecId;

    private Integer year;

    private LocalDate submittedDate;

    private String status; // e.g., PENDING, APPROVED, REJECTED

    @Column(length = 500)
    private String comments;

    private String updatedBy;

    private LocalDate updatedAt;

    private int totalParticipants;

    private int totalInstruktorzy;

    private int totalZbiorki;

    private int totalWycieczki;
}
