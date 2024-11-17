package com.zhpwb.harcrej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "person")
@Entity
public class PersonEntity {

    @Id
    @GeneratedValue
    private Integer personId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dateOfBirth;
    private AddressDto address;
    private StopienDto stopien;

}
