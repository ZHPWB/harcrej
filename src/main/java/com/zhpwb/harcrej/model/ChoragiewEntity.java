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

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "choragiew")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ChoragiewEntity {

    @GeneratedValue
    @Id
    private int choragiewId;
    private CountryEntity country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "komendant_choragwi_id")
    private UserEntity komendantChoragwi;
    @OneToMany(mappedBy = "choragiew", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HufiecEntity> hufce;

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
