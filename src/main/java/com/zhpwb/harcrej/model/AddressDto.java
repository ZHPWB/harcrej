package com.zhpwb.harcrej.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AddressDto {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
}
