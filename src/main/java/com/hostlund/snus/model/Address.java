package com.hostlund.snus.model;

import com.neovisionaries.i18n.CountryCode;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {

  private UUID id;
  private Integer houseNumber;
  private String firstLine;
  private String secondLine;
  private String city;
  private String state;
  private String postalCode;
  private CountryCode country;
}
