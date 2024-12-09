package com.zhpwb.harcrej.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rejestracje")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Integer createdBy;
    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;
}
