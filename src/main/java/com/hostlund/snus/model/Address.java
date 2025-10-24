package com.hostlund.snus.model;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    private Integer houseNumber;
    private String firstLine;
    private String secondLine;
    private String city;
    private String state;
    private String postalCode;
    private CountryCode country;
}
