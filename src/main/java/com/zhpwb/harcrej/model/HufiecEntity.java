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
@Table(name = "hufiec")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
