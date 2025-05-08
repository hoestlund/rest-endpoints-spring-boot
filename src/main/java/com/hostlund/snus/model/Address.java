package com.hostlund.snus.model;

import com.neovisionaries.i18n.CountryCode;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {

  Integer houseNumber;
  String firstLine;
  String secondLine;
  String city;
  String state;
  String postalCode;
  CountryCode cc;
}
