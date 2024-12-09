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
@Table(name = "druzyna")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
    private UserEntity druzynowy;
    private TypeDto type;
    private List<UserEntity> komenda;
    @Embedded
    private StatsDto currentStats;
    private String yearEstablished;

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
