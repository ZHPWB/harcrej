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
@Table(name = "szczep")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SzczepEntity {

    @GeneratedValue
    @Id
    private int szczepId;
    private String name;
    private String areaOfOperation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "szczepowy_id")
    private UserEntity szczepowy;
    @OneToMany(mappedBy = "szczep")
    private List<DruzynaEntity> druzyny;
    @ManyToOne
    @JoinColumn(name = "hufiec_id")
    private HufiecEntity hufiec;

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
